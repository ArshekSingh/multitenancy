package com.multitenancy.sso.security;

import com.multitenancy.sso.config.TenantContext;
import com.multitenancy.sso.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        String tenantId = request.getHeader("X-Tenant-ID");

        String username = null;
        String jwt = null;

        String host = request.getServerName();
        if(!host.isEmpty()) {
            String tenantId1 = extractTenantFromSubdomain(host);
            if (tenantId1 != null) {
                TenantContext.setCurrentTenant(tenantId1);
            }
        }


        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                username = jwtUtil.extractUsername(jwt);
                tenantId = jwtUtil.extractTenantId(jwt);
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                TenantContext.setCurrentTenant(tenantId);

                if (Boolean.FALSE.equals(jwtUtil.isTokenExpired(jwt))) {
                    List<String> roles = jwtUtil.extractRoles(jwt);
                    List<GrantedAuthority> authorities = roles.stream()
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList());

                    UserDetails userDetails = new User(username, "", authorities);

                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                else {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("Token is expired");
                }
            }

            if(tenantId != null) {
                TenantContext.setCurrentTenant(tenantId);
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("Exception occurred due to : {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid or expired token");
        } finally {
            // Clear the tenant context after the request completes to avoid memory issues.
            TenantContext.clear();
        }
    }

    private String extractTenantFromSubdomain(String host) {
        String[] parts = host.split("\\.");
        if (parts.length > 2) { // tenant.example.com
            return parts[0]; // Extract tenant part
        }
        return null; // Return null if not a subdomain
    }
}

package com.multitenancy.sso.controller;

import com.multitenancy.sso.dto.LoginUserDto;
import com.multitenancy.sso.dto.RegisterUserDto;
import com.multitenancy.sso.dto.Response;
import com.multitenancy.sso.entity.User;
import com.multitenancy.sso.service.AuthService;
import com.multitenancy.sso.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.multitenancy.sso.util.Constants.SUCCESS;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    private final AuthService authenticationService;

    public AuthController(JwtUtil jwtUtil, AuthService authenticationService) {
        this.jwtUtil = jwtUtil;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public Response<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return new Response<>(HttpStatus.OK, SUCCESS, registeredUser);
    }

    @PostMapping("/login")
    public Response<String> createAuthenticationToken(@RequestBody LoginUserDto loginUserDto, HttpServletRequest request) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String tenantId = request.getHeader("X-Tenant-ID");
        String jwtToken = jwtUtil.generateToken(authenticatedUser, tenantId);
        return new Response<>(HttpStatus.OK, SUCCESS, jwtToken);
    }

}

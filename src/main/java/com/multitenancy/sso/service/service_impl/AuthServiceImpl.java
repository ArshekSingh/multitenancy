package com.multitenancy.sso.service.service_impl;

import com.multitenancy.sso.dto.LoginUserDto;
import com.multitenancy.sso.dto.RegisterUserDto;
import com.multitenancy.sso.entity.User;
import com.multitenancy.sso.repository.UserRepository;
import com.multitenancy.sso.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User()
        .setFullName(input.getFullName())
                .setLoggedInUserId(input.getLoggedInUserId())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setMobileNumber(input.getMobileNumber())
                .setBusinessId(input.getBusinessId());
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getLoggedInUserId(),
                        input.getPassword()
                )
        );
        if(authenticate.isAuthenticated()) {
            return userRepository.findByLoggedInUserId(input.getLoggedInUserId())
                    .orElseThrow();
        }
        throw new BadCredentialsException("Authentication failed for user : " + input.getLoggedInUserId());
    }
}

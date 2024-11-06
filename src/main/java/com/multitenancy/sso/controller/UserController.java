package com.multitenancy.sso.controller;


import com.multitenancy.sso.dto.Response;
import com.multitenancy.sso.entity.User;
import com.multitenancy.sso.repository.UserRepository;
import com.multitenancy.sso.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/setUserDetails")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);

    }

    @GetMapping("/getUserDetails")
    public Response<User> getUserDetails(@RequestParam String username) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails principal1 = (UserDetails) principal;

        org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return new Response<>(HttpStatus.OK, Constants.SUCCESS, userRepository.findByLoggedInUserId(username).get());
    }
}

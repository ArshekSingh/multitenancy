package com.multitenancy.sso.service;

import com.multitenancy.sso.dto.LoginUserDto;
import com.multitenancy.sso.dto.RegisterUserDto;
import com.multitenancy.sso.entity.User;

public interface AuthService {

    User signup(RegisterUserDto input);

    User authenticate(LoginUserDto input);
}

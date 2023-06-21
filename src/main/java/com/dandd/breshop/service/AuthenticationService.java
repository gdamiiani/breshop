package com.dandd.breshop.service;

import com.dandd.breshop.dto.LoginDTO;
import com.dandd.breshop.dto.AuthenticationDTO;
import com.dandd.breshop.dto.CreateUserDTO;

public interface AuthenticationService {
    AuthenticationDTO register(CreateUserDTO request);
    AuthenticationDTO authenticate(LoginDTO request);
}

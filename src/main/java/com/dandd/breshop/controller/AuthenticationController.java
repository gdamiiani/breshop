package com.dandd.breshop.controller;

import com.dandd.breshop.dto.LoginDTO;
import com.dandd.breshop.dto.AuthenticationDTO;
import com.dandd.breshop.dto.CreateUserDTO;
import com.dandd.breshop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationDTO> signup(
            @RequestBody CreateUserDTO request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(
            @RequestBody LoginDTO request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

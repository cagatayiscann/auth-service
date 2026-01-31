package com.cagatayiscan.auth_service.Core.controller;


import com.cagatayiscan.auth_service.Core.auth.dto.LoginRequest;
import com.cagatayiscan.auth_service.Core.auth.dto.LoginResponse;
import com.cagatayiscan.auth_service.Core.auth.service.AuthService;
import com.cagatayiscan.auth_service.Core.auth.service.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        long userId = authService.authenticate(req.getUsername(), req.getPassword());
        String token = jwtService.issueToken(userId, req.getUsername());
        return new LoginResponse(token);
    }
}

package com.cagatayiscan.auth_service.Core.auth.service;

import org.springframework.stereotype.Service;
@Service
public class AuthService {

    //şimdilik sabit kullanıcı
    private static final String USERNAME = "cagatay";
    private static final String PASSWORD = "1234";
    private static final long USER_ID = 1L;

    public long authenticate(String username, String password) {
        if (USERNAME.equals(username) && (PASSWORD.equals(password))) {
            return USER_ID;
        }
        throw new RuntimeException("Invalid Credentials");
    }
}

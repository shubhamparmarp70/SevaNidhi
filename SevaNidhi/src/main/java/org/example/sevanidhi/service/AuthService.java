package org.example.sevanidhi.service;

import org.example.sevanidhi.dto.*;
import org.springframework.stereotype.Service;

public interface AuthService {
    void register(RegisterRequest request);

    void verifyOtp(String email, String otp);

    AuthResponse login(LoginRequest request);
}

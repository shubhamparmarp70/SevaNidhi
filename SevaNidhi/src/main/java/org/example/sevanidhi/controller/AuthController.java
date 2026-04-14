package org.example.sevanidhi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.sevanidhi.dto.AuthResponse;
import org.example.sevanidhi.dto.LoginRequest;
import org.example.sevanidhi.dto.RegisterRequest;
import org.example.sevanidhi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("OTP sent to email and mobile");
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email,
                                            @RequestParam String otp) {
        authService.verifyOtp(email, otp);
        return ResponseEntity.ok("Account activated successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

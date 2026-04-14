package org.example.sevanidhi.service.impl;

import org.example.sevanidhi.dto.AuthResponse;
import org.example.sevanidhi.dto.LoginRequest;
import org.example.sevanidhi.dto.RegisterRequest;
import org.example.sevanidhi.repository.RoleRepository;
import org.example.sevanidhi.repository.UserRepository;
import org.example.sevanidhi.security.JwtUtil;
import org.example.sevanidhi.service.AuthService;
import org.example.sevanidhi.service.OTPService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final OTPService otpService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           OTPService otpService,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.otpService = otpService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void register(RegisterRequest request) {

    }

    @Override
    public void verifyOtp(String email, String otp) {

    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }

    // implement your methods here
}
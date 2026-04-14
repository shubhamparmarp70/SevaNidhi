package org.example.sevanidhi.service;

public interface OTPService {
    void sendOtp(String email, String mobile);

    void verifyOtp(String email, String otp);
}

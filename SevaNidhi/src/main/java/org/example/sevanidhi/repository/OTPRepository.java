package org.example.sevanidhi.repository;

import org.example.sevanidhi.security.OTPVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OTPRepository extends JpaRepository<OTPVerification, Long> {

    Optional<OTPVerification> findByEmailAndOtp(String email, String otp);

}
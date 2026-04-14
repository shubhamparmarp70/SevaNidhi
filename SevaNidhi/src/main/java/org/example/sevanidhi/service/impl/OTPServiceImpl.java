package org.example.sevanidhi.service.impl;

import org.example.sevanidhi.repository.OTPRepository;
import org.example.sevanidhi.security.OTPVerification;
import org.example.sevanidhi.service.OTPService;
import org.example.sevanidhi.util.OTPGenerator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OTPServiceImpl implements OTPService {
    private static final Logger log = LoggerFactory.getLogger(OTPServiceImpl.class);

    private final OTPRepository otpRepository;

    public OTPServiceImpl(OTPRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    @Override
    public void sendOtp(String email, String mobile) {

        String otp = OTPGenerator.generate();

        OTPVerification otpEntity = new OTPVerification();
        otpEntity.setEmail(email);
        otpEntity.setMobile(mobile);
        otpEntity.setOtp(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);

        otpRepository.save(otpEntity);

        log.info("Email OTP for {}: {}", email, otp);
        log.info("SMS OTP for {}: {}", mobile, otp);
    }

    @Override
    @Transactional
    public void verifyOtp(String email, String otp) {

        OTPVerification entity = otpRepository
                .findByEmailAndOtp(email, otp)
                .orElseThrow(() -> new RuntimeException("Invalid OTP"));

        if (entity.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP Expired");
        }

        entity.setVerified(true);
        otpRepository.save(entity);
        log.info("OTP verified for {}", email);
    }
}

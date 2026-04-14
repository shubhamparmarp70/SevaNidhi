package org.example.sevanidhi.security;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "otp_verifications")
public class OTPVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String mobile;
    private String otp;
    private LocalDateTime expiryTime;
    private boolean verified;

    public OTPVerification() {
    }

    public OTPVerification(Long id, String email, String mobile,
                           String otp, LocalDateTime expiryTime, boolean verified) {
        this.id = id;
        this.email = email;
        this.mobile = mobile;
        this.otp = otp;
        this.expiryTime = expiryTime;
        this.verified = verified;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }

    public LocalDateTime getExpiryTime() { return expiryTime; }
    public void setExpiryTime(LocalDateTime expiryTime) { this.expiryTime = expiryTime; }

    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }
}
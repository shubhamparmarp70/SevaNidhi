package org.example.sevanidhi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String action;
    private String ipAddress;
    private LocalDateTime timestamp;

    // Default constructor (REQUIRED by JPA)
    public AuditLog() {
    }

    // Optional constructor
    public AuditLog(String username, String action, String ipAddress, LocalDateTime timestamp) {
        this.username = username;
        this.action = action;
        this.ipAddress = ipAddress;
        this.timestamp = timestamp;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAction() {
        return action;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
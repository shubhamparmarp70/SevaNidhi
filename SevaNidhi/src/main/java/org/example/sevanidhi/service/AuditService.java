package org.example.sevanidhi.service;

public interface AuditService {
    void log(String username, String action, String ip);
}

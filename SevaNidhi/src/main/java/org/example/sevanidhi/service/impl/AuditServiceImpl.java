package org.example.sevanidhi.service.impl;

import org.example.sevanidhi.entity.AuditLog;
import org.example.sevanidhi.repository.AuditLogRepository;
import org.example.sevanidhi.service.AuditService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditLogRepository auditLogRepository;

    // ✅ Manually created constructor (Spring will use this)
    public AuditServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public void log(String username, String action, String ip) {

        AuditLog log = new AuditLog();
        log.setUsername(username);
        log.setAction(action);
        log.setIpAddress(ip);
        log.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(log);
    }
}
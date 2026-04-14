package org.example.sevanidhi.repository;


import org.example.sevanidhi.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}
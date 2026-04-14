package org.example.sevanidhi.repository;

import org.example.sevanidhi.entity.Application;
import org.example.sevanidhi.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    long countByStatus(ApplicationStatus status);

    @Query("SELECT COUNT(a) FROM Application a WHERE a.user.aadhaarNumber = :aadhaar")
    long countByUserAadhaarNumber(@Param("aadhaar") String aadhaar);
}

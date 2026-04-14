package org.example.sevanidhi.repository;

import org.example.sevanidhi.entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {

    @Query("SELECT SUM(s.totalBudget) FROM Scheme s")
    BigDecimal sumTotalBudget();
}


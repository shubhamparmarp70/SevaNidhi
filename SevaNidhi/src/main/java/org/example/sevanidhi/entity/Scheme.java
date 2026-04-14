package org.example.sevanidhi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "schemes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    @Column(nullable = false)
    private BigDecimal totalBudget;

    @Column(nullable = false)
    private BigDecimal disbursedAmount;

    @Column(nullable = false)
    private boolean active;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

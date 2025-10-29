package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TechMaturityAssessment {
    private Long id;
    private Long projectId;
    private Long assessorId;
    private Long assessmentRound;
    private Integer technologyReadinessLevel;
    private BigDecimal marketReadinessScore;
    private BigDecimal commercialPotentialScore;
    private Integer riskLevel;
    private String assessmentContent;
    private String improvementSuggestions;
    private String nextMilestone;
    private LocalDate assessmentDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CooperationProject {
    private Long id;
    private String projectName;
    private String projectCode;
    private Long enterpriseId;
    private Long departmentId;
    private Integer projectType;
    private Integer cooperationMode;
    private Long projectLeaderId;
    private Long enterpriseContactId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal budget;
    private BigDecimal actualAmount;
    private String projectDescription;
    private String objectives;
    private String deliverables;
    private String riskAssessment;
    private Integer progressStatus;
    private BigDecimal qualityScore;
    private BigDecimal satisfactionScore;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
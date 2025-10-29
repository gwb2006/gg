package com.example.demo.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RoadshowMatch {
    private Long id;
    private Long projectId;
    private String investorType;
    private String investorName;
    private String contactPerson;
    private String contactInfo;
    private BigDecimal matchScore;
    private String matchReason;
    private LocalDate roadshowDate;
    private String roadshowResult;
    private String feedback;
    private String followUpActions;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
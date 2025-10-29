package com.example.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Enterprise {
    private Long id;
    private String name;
    private String shortName;
    private String unifiedSocialCreditCode;
    private Integer enterpriseType;
    private String industry;
    private Integer scale;
    private String contactPerson;
    private String contactPhone;
    private String contactEmail;
    private String address;
    private String website;
    private String businessScope;
    private String tags; // JSON类型，使用String存储
    private String cooperationHistory; // JSON类型，使用String存储
    private Integer creditRating;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
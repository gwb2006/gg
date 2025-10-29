package com.example.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Department {
    private Long id;
    private String name;
    private String code;
    private Long parentId;
    private Long managerId;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
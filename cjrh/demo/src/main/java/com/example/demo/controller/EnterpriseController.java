package com.example.demo.controller;

import com.example.demo.entity.Enterprise;
import com.example.demo.service.EnterpriseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enterprises")
@Tag(name = "企业管理", description = "企业相关的CRUD操作")
public class EnterpriseController {
    
    @Autowired
    private EnterpriseService enterpriseService;
    
    @Operation(summary = "获取所有企业", description = "查询系统中所有企业信息")
    @GetMapping
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.list();
    }
    
    @Operation(summary = "获取单个企业", description = "根据ID查询指定企业信息")
    @GetMapping("/{id}")
    public Enterprise getEnterpriseById(@PathVariable Long id) {
        return enterpriseService.getById(id);
    }
    
    @Operation(summary = "创建企业", description = "新增企业信息")
    @PostMapping
    public boolean createEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseService.save(enterprise);
    }
    
    @Operation(summary = "更新企业", description = "更新指定企业信息")
    @PutMapping("/{id}")
    public boolean updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterprise) {
        enterprise.setId(id);
        return enterpriseService.updateById(enterprise);
    }
    
    @Operation(summary = "删除企业", description = "删除指定企业信息")
    @DeleteMapping("/{id}")
    public boolean deleteEnterprise(@PathVariable Long id) {
        return enterpriseService.removeById(id);
    }
}
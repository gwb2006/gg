package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "部门管理", description = "部门相关的CRUD操作")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(summary = "获取所有部门", description = "查询系统中所有部门信息")
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.list();
    }

    @Operation(summary = "获取单个部门", description = "根据ID查询指定部门信息")
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getById(id);
    }

    @Operation(summary = "创建部门", description = "新增部门信息")
    @PostMapping
    public boolean createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @Operation(summary = "更新部门", description = "更新指定部门信息")
    @PutMapping("/{id}")
    public boolean updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        return departmentService.updateById(department);
    }

    @Operation(summary = "删除部门", description = "删除指定部门信息")
    @DeleteMapping("/{id}")
    public boolean deleteDepartment(@PathVariable Long id) {
        return departmentService.removeById(id);
    }
}
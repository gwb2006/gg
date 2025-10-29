package com.example.demo.controller;

import com.example.demo.entity.CooperationProject;
import com.example.demo.service.CooperationProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cooperation-projects")
@Tag(name = "合作项目管理", description = "合作项目相关的CRUD操作")
public class CooperationProjectController {

    @Autowired
    private CooperationProjectService cooperationProjectService;

    @Operation(summary = "获取所有项目", description = "查询系统中所有合作项目信息")
    @GetMapping
    public List<CooperationProject> getAllProjects() {
        return cooperationProjectService.list();
    }

    @Operation(summary = "获取单个项目", description = "根据ID查询指定合作项目信息")
    @GetMapping("/{id}")
    public CooperationProject getProjectById(@PathVariable Long id) {
        return cooperationProjectService.getById(id);
    }

    @Operation(summary = "创建项目", description = "新增合作项目信息")
    @PostMapping
    public boolean createProject(@RequestBody CooperationProject cooperationProject) {
        return cooperationProjectService.save(cooperationProject);
    }

    @Operation(summary = "更新项目", description = "更新指定合作项目信息")
    @PutMapping("/{id}")
    public boolean updateProject(@PathVariable Long id, @RequestBody CooperationProject cooperationProject) {
        cooperationProject.setId(id);
        return cooperationProjectService.updateById(cooperationProject);
    }

    @Operation(summary = "删除项目", description = "删除指定合作项目信息")
    @DeleteMapping("/{id}")
    public boolean deleteProject(@PathVariable Long id) {
        return cooperationProjectService.removeById(id);
    }
}
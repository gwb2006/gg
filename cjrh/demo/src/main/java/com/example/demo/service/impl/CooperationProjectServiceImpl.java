package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.CooperationProject;
import com.example.demo.mapper.CooperationProjectMapper;
import com.example.demo.service.CooperationProjectService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CooperationProjectServiceImpl extends ServiceImpl<CooperationProjectMapper, CooperationProject> implements CooperationProjectService {

    @Override
    public boolean save(CooperationProject cooperationProject) {
        cooperationProject.setCreatedAt(LocalDateTime.now());
        cooperationProject.setUpdatedAt(LocalDateTime.now());
        return super.save(cooperationProject);
    }

    @Override
    public boolean updateById(CooperationProject cooperationProject) {
        cooperationProject.setUpdatedAt(LocalDateTime.now());
        return super.updateById(cooperationProject);
    }
}
package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.TechMaturityAssessment;
import com.example.demo.mapper.TechMaturityAssessmentMapper;
import com.example.demo.service.TechMaturityAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class TechMaturityAssessmentServiceImpl extends ServiceImpl<TechMaturityAssessmentMapper, TechMaturityAssessment> implements TechMaturityAssessmentService {
    // 继承ServiceImpl后已包含常用CRUD方法，如需自定义实现可重写相关方法
}
package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Enterprise;
import com.example.demo.mapper.EnterpriseMapper;
import com.example.demo.service.EnterpriseService;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements EnterpriseService {
    // 继承ServiceImpl后已包含常用CRUD方法，如需自定义实现可重写相关方法
}
package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Enterprise;

public interface EnterpriseService extends IService<Enterprise> {
    // 继承IService后已包含常用CRUD方法，如需扩展可在此添加自定义方法
}
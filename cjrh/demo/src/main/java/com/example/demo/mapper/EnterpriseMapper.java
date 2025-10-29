package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Enterprise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseMapper extends BaseMapper<Enterprise> {
    // 继承BaseMapper后已包含常用CRUD方法，无需手动定义
}
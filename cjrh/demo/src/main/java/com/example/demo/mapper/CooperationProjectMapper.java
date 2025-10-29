package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.CooperationProject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CooperationProjectMapper extends BaseMapper<CooperationProject> {
    // 继承BaseMapper后已包含常用CRUD方法，无需手动定义
}
package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.RoadshowMatch;
import com.example.demo.mapper.RoadshowMatchMapper;
import com.example.demo.service.RoadshowMatchService;
import org.springframework.stereotype.Service;

@Service
public class RoadshowMatchServiceImpl extends ServiceImpl<RoadshowMatchMapper, RoadshowMatch> implements RoadshowMatchService {
    // 继承ServiceImpl后已包含常用CRUD方法，如需自定义实现可重写相关方法
}
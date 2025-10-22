package com.example.cjrh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 主页控制器
 * 处理根路径请求，避免显示404错误页面
 */
@RestController
public class HomeController {

    /**
     * 处理根路径请求
     * 提供应用基本信息和API访问指南
     *
     * @return 包含应用信息和API指引的Map对象
     */
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        
        // 应用基本信息
        response.put("application", "cjrh");
        response.put("version", "0.0.1-SNAPSHOT");
        response.put("status", "success");
        response.put("message", "应用程序运行正常");
        
        // API访问指引
        Map<String, String> apiGuide = new HashMap<>();
        apiGuide.put("apiPrefix", "/api");
        apiGuide.put("testEndpoints", "请访问 /api/test/info, /api/test/ping, /api/test/health 测试API");
        apiGuide.put("userEndpoints", "用户管理API在 /api/users 路径下");
        apiGuide.put("documentation", "详细API文档请参考项目中的API_DOCUMENTATION.md文件");
        
        response.put("apiGuide", apiGuide);
        
        return response;
    }
}
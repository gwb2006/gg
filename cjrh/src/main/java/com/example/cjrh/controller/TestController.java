package com.example.cjrh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器，用于验证项目是否正常运行
 * 
 * @author AI Assistant
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * 获取测试信息
     * 用于验证应用程序是否正常运行
     * 
     * @return 包含测试信息的Map对象
     */
    @GetMapping("/info")
    public Map<String, Object> getTestInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("message", "应用程序运行正常");
        result.put("timestamp", System.currentTimeMillis());
        result.put("application", "cjrh");
        result.put("version", "0.0.1-SNAPSHOT");
        
        return result;
    }
    
    /**
     * 测试数据库连接状态
     * 通过检查系统当前时间来验证服务器响应
     * 
     * @return 包含当前时间的Map对象
     */
    @GetMapping("/ping")
    public Map<String, Object> ping() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "pong");
        result.put("currentTime", new java.util.Date().toString());
        return result;
    }
    
    /**
     * 获取应用程序健康状态
     * 提供更详细的系统信息
     * 
     * @return 包含健康状态信息的Map对象
     */
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> healthInfo = new HashMap<>();
        
        // 系统信息
        Map<String, String> systemInfo = new HashMap<>();
        systemInfo.put("javaVersion", System.getProperty("java.version"));
        systemInfo.put("osName", System.getProperty("os.name"));
        systemInfo.put("osVersion", System.getProperty("os.version"));
        
        healthInfo.put("status", "UP");
        healthInfo.put("system", systemInfo);
        healthInfo.put("memory", getMemoryInfo());
        healthInfo.put("timestamp", System.currentTimeMillis());
        
        return healthInfo;
    }
    
    /**
     * 获取内存信息
     * 
     * @return 内存信息Map
     */
    private Map<String, Object> getMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        Map<String, Object> memory = new HashMap<>();
        memory.put("maxMemory", runtime.maxMemory() / 1024 / 1024);
        memory.put("totalMemory", runtime.totalMemory() / 1024 / 1024);
        memory.put("freeMemory", runtime.freeMemory() / 1024 / 1024);
        memory.put("usedMemory", (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024);
        return memory;
    }
}
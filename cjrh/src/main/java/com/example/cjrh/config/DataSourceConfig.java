package com.example.cjrh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 数据源配置类
 * 用于配置数据库连接相关的属性
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {
    // 可以在这里添加额外的数据源配置属性和方法
}
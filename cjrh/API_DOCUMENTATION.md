# API文档

## 项目简介

这是一个基于Spring Boot的用户管理系统，提供用户的CRUD操作和系统测试功能。

## 基础信息

- **项目名称**：cjrh
- **版本**：0.0.1-SNAPSHOT
- **基础URL**：`http://localhost:8080`
- **认证方式**：当前版本暂未实现认证机制

## 目录结构

本项目采用标准的Spring Boot分层架构：

- **controller**: 处理HTTP请求，提供RESTful接口
- **entity**: 数据实体类，映射数据库表
- **service**: 业务逻辑层
- **mapper**: 数据访问层，使用Spring Data JPA

## 模块列表

1. **用户管理模块**：提供用户的CRUD操作
2. **测试模块**：提供系统运行状态和健康检查

## API详情

### 1. 用户管理模块

#### 1.1 获取所有用户

- **路径**：`/api/users`
- **方法**：GET
- **描述**：获取系统中所有用户的列表
- **请求参数**：无
- **响应示例**：

```json
[
  {
    "id": 1,
    "username": "admin",
    "password": "$2a$10$abcdefg",
    "nickname": "管理员",
    "email": "admin@example.com",
    "phone": "13800138000",
    "status": 1,
    "createTime": "2025-10-15T18:24:56",
    "updateTime": "2025-10-15T18:24:56"
  }
]
```

#### 1.2 根据ID获取用户

- **路径**：`/api/users/{id}`
- **方法**：GET
- **描述**：根据用户ID获取指定用户的详细信息
- **请求参数**：
  - `id`：用户ID（路径参数，必填）
- **响应示例**：

```json
{
  "id": 1,
  "username": "admin",
  "password": "$2a$10$abcdefg",
  "nickname": "管理员",
  "email": "admin@example.com",
  "phone": "13800138000",
  "status": 1,
  "createTime": "2025-10-15T18:24:56",
  "updateTime": "2025-10-15T18:24:56"
}
```

#### 1.3 创建新用户

- **路径**：`/api/users`
- **方法**：POST
- **描述**：创建一个新的用户账户
- **请求体**：

```json
{
  "username": "newuser",
  "password": "password123",
  "nickname": "新用户",
  "email": "newuser@example.com",
  "phone": "13900139000",
  "status": 1
}
```

- **响应示例**：

```json
{
  "id": 2,
  "username": "newuser",
  "password": "$2a$10$abcdefg",
  "nickname": "新用户",
  "email": "newuser@example.com",
  "phone": "13900139000",
  "status": 1,
  "createTime": "2025-10-15T18:30:00",
  "updateTime": "2025-10-15T18:30:00"
}
```

#### 1.4 更新用户信息

- **路径**：`/api/users/{id}`
- **方法**：PUT
- **描述**：更新指定用户的信息
- **请求参数**：
  - `id`：用户ID（路径参数，必填）
- **请求体**：

```json
{
  "username": "updateduser",
  "password": "newpassword123",
  "nickname": "已更新用户",
  "email": "updateduser@example.com",
  "phone": "13700137000",
  "status": 1
}
```

- **响应示例**：

```json
{
  "id": 2,
  "username": "updateduser",
  "password": "$2a$10$abcdefg",
  "nickname": "已更新用户",
  "email": "updateduser@example.com",
  "phone": "13700137000",
  "status": 1,
  "createTime": "2025-10-15T18:30:00",
  "updateTime": "2025-10-15T18:35:00"
}
```

#### 1.5 删除用户

- **路径**：`/api/users/{id}`
- **方法**：DELETE
- **描述**：删除指定ID的用户
- **请求参数**：
  - `id`：用户ID（路径参数，必填）
- **响应**：无内容（HTTP状态码：204 No Content）

### 2. 测试模块

#### 2.1 获取应用基本信息

- **路径**：`/api/test/info`
- **方法**：GET
- **描述**：获取应用程序的基本信息和运行状态
- **请求参数**：无
- **响应示例**：

```json
{
  "status": "success",
  "message": "应用程序运行正常",
  "timestamp": 1734294296789,
  "application": "cjrh",
  "version": "0.0.1-SNAPSHOT"
}
```

#### 2.2 测试服务器响应

- **路径**：`/api/test/ping`
- **方法**：GET
- **描述**：测试服务器是否正常响应
- **请求参数**：无
- **响应示例**：

```json
{
  "status": "pong",
  "currentTime": "Wed Oct 15 18:36:45 CST 2025"
}
```

#### 2.3 获取系统健康状态

- **路径**：`/api/test/health`
- **方法**：GET
- **描述**：获取系统的详细健康状态信息
- **请求参数**：无
- **响应示例**：

```json
{
  "status": "UP",
  "system": {
    "javaVersion": "17.0.1",
    "osName": "Windows 10",
    "osVersion": "10.0"
  },
  "memory": {
    "maxMemory": 4096,
    "totalMemory": 1024,
    "freeMemory": 512,
    "usedMemory": 512
  },
  "timestamp": 1734294296790
}
```

## 数据模型

### User（用户实体）

| 字段名 | 类型 | 描述 | 是否必填 | 备注 |
|--------|------|------|----------|------|
| id | Long | 用户ID | 否 | 主键，自动生成 |
| username | String | 用户名 | 是 | 唯一，最大长度50 |
| password | String | 密码 | 是 | 最大长度100 |
| nickname | String | 昵称 | 否 | 最大长度50 |
| email | String | 邮箱 | 否 | 最大长度100 |
| phone | String | 手机号 | 否 | 最大长度20 |
| status | Integer | 状态 | 否 | 1表示启用，0表示禁用 |
| createTime | LocalDateTime | 创建时间 | 否 | 自动生成 |
| updateTime | LocalDateTime | 更新时间 | 否 | 自动更新 |

## 错误处理

系统在遇到错误时会返回适当的HTTP状态码和错误信息：

| 状态码 | 描述 | 可能原因 |
|--------|------|----------|
| 400 | Bad Request | 请求参数错误或格式不符合要求 |
| 404 | Not Found | 请求的资源不存在 |
| 500 | Internal Server Error | 服务器内部错误 |

## 部署和运行

### 环境要求

- JDK 17或更高版本
- Maven 3.6+ 或 Gradle 7.0+
- MySQL 8.0+ 数据库

### 运行方式

1. 使用Maven命令运行：
   ```bash
   mvn spring-boot:run
   ```

2. 或打包后运行：
   ```bash
   mvn package
   java -jar target/cjrh-0.0.1-SNAPSHOT.jar
   ```

### 配置文件

主要配置文件位于 `src/main/resources/application.properties`，包含数据库连接信息和应用配置。

## 版本历史

- **0.0.1-SNAPSHOT**：初始版本，包含基本的用户管理功能和测试接口
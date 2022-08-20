## Maven基本使用

#### Maven常用命令

- compile：编译
- clean：清理
- test：测试
- package：打包
- install：安装

#### Maven坐标详解

- 什么是坐标
  - Maven中的坐标是资源唯一标识符
  - 使用坐标来定义项目或引入项目中所需要的依赖
- Maven坐标主要组成
  - groupId：定义当前Maven项目隶属组织名称(通常是域名反写)
  - artifactId：定义当前Maven项目名称(通常是模块名称)
  - version：定义当前项目版本号

#### 依赖管理

使用坐标导入jar包

1. 在pom.xml中编写\<dependencies\>标签
2. 在\<dependencies>标签中使用\<dependency>引入标签
3. 定义坐标的groupId，artfactId，version



#### 依赖范围

- 通过设置坐标的依赖范围，可以设置对应jar包的作用范围：编译环境，测试环境，运行环境

![依赖管理](/Users/luckyzhong/Documents/JavaWeb/Maven/images/依赖管理.jpg)
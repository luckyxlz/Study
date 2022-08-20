## Mysql 日志查看

#### 1.进入mysql，修改设置

```mysql
set global general_log = on
```

#### 2. 查看mysql的日志文件所在位置

```mysql
show variables like "general_log_file"
```

#### 3. 在终端用tail -f 命令打开该日志文件：


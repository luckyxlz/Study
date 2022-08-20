# Session

### Session基本使用

- 服务端会话跟踪技术：将数据保存到**服务端**
- JavaEE提供HttpSession接口，来实现**一次会话的多次请求间**数据共享
- 使用：
  1. 获取Session对象
  2. Session对象功能
     - ```java
     	void setAttribute(String name,Object o)：存储数据到session域中
     	Object getAttribute(String name)：根据key，获取值
     	void removeAttribute(String name)：根据key，删除该键值对
     	```
     
     	



### Session原理

- Session是基于Cookie实现的



### Session使用细节

- Session钝化，活化：

  - 服务器重启后，Session中的数据是否还存在
    - **钝化**：在服务器正常关闭时，Tomcat会自动将Session数据写入硬盘文件中
    - **活化**：再次启动服务器后，从文件中加载数据到session中

- Session销毁：

  - 默认情况下，无操作，30分钟自动销毁

  - 调用Session对象的invalidate()方法

  - ```xml
    <session-config>
    	<session-timeout>30</session-timeout>
    </session-config>
    ```

    
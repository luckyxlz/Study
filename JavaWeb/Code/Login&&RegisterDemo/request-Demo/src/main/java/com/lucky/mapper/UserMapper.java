package com.lucky.mapper;

import com.lucky.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /*根据用户名查找用户*/
    @Select("SELECT * from tb_user where username = #{usename}")
    User selectByUsername(String username);

    /*添加用户*/
    @Insert("INSERT INTO tb_user values (null,#{username},#{password})")
    void add(User user);
}

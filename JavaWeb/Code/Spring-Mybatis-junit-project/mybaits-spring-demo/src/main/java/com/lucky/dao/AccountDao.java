package com.lucky.dao;

import com.lucky.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface AccountDao {


    // 添加用户
    @Insert("INSERT INTO account(name,money) VALUES (#{name},#{money})")
    void save(Account account);

    // 删除用户
    @Delete("DELETE FROM account where id = #{id}")
    void delete(Integer id);

    // 修改用户数据
    @Update("UPDATE account set name = #{name},money = #{money} where id = #{id}")
    void update(Account account);

    // 查询所有
    @Select("SELECT * from account")
    List<Account> findAll();

    // 通过ID查询用户
    @Select("SELECT * from account where id = #{id}")
    Account findById(Integer id);

}

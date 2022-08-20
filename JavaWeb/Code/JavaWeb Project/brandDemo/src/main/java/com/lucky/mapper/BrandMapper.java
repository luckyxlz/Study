package com.lucky.mapper;

import com.lucky.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("BrandResult")
    List<Brand> selectAll();

    //使用散装参数传参
//    List<Brand> selectByCondition(
//            @Param("status") int status,
//            @Param("companyName") String companyName,
//            @Param("brandName") String brandName
//    );
    //使用对象参数传参
//    List<Brand> selectByCondition(Brand brand);
    //使用map传参
    List<Brand> selectByCondition(Map map);
    List<Brand> selectByConditionSingle(Brand brand);

    /*
    数据添加
    * */
    void add(Brand brand);

    /*
    * 修改
    * */

    int update(Brand brand);

    /*
    * 删除
    * */
    int deleteById(int id);

    int deleteByIds(@Param("ids") int[] ids);

}

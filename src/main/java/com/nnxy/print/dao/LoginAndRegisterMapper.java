package com.nnxy.print.dao;


import com.nnxy.print.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginAndRegisterMapper {

    /**
     * 插入一个用户到User表
     * @param user
     * @return
     */
    @Insert("insert into user(number,name,phone,password) values(#{registerNum},#{name},#{phone},#{password})")
    Integer insert(User user);

    @Select("select count(1) from user where number = #{registerNum}")
    Integer exist(@Param("registerNum") String registerNum);
}

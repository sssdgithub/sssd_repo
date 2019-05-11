package com.sssd.mybatis.mapper;


import com.sssd.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "uid",property = "uid"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "uid",property = "orders",many = @Many(select = "com.sssd.mybatis.mapper.OrderMapper.findByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Insert("insert into user(username,password) values(username,password)")
    void save(User user);

    @Delete("delete from user where uid = #{id}")
    void delete(Integer id);

    @Update("update user set username=#{username},password=#{password} where uid = #{uid}")
    void update(User user);

    @Select("select * from user where uid = #{id}")
    User findById(Integer id);

    @Select("select * from user where username like #{username}")
    List<User> findByUsername(String username);

    @Select("select count(*) from user")
    Integer findTotal();

    @Select("select * from user LEFT OUTER JOIN `order` on user.uid = `order`.uid where `order`.oid = #{oid}")
    User findByOid(Integer oid);


}

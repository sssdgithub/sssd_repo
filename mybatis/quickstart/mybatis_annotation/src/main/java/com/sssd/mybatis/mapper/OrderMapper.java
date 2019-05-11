package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {
    @Select("select * from `order`")
    @Results(id="orderMap",value={
            @Result(id=true,property = "oid",column = "oid"),
            @Result(property = "name",column = "name"),
            @Result(property = "user",column = "uid",one=@One(select = "com.sssd.mybatis.mapper.UserMapper.findByOid",fetchType = FetchType.EAGER))
    })
    List<Order> findAll();

    @Select("select * from `order` where uid = #{uid}")
    @ResultMap(value={"orderMap"})
    Order findByUid(Integer uid);
}

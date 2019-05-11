package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.QueryVo;
import com.sssd.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);

    List<User> findByUsername(String username);

    List<User> findByVo(QueryVo queryVo);

    Integer getCount();

    List<User> findByCondition(User user);

    List<User> findByIds(QueryVo queryVo);

}

package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}

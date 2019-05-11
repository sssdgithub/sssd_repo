package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll();

    Role findByUid(Integer uid);
}

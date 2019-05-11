package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> findAll();

    Menu findById(Integer pid);
}

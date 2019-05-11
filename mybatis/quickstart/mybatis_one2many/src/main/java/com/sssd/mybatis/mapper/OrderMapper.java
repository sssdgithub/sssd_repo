package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.Order;

public interface OrderMapper {
    Order findByUid(Integer uid);
}

package com.sssd.mybatis.mapper;

import com.sssd.mybatis.entity.Card;

import java.util.List;

public interface CardMapper {
    List<Card> findAll();
}

package com.sssd.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryVo implements Serializable {
    private User user;
    private List<Integer> ids;
}

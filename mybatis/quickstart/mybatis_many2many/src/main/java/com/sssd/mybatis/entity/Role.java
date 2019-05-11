package com.sssd.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Role implements Serializable {
    private Integer rid;
    private String name;
    private List<User> users;
}

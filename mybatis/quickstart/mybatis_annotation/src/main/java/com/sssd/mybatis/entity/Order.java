package com.sssd.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private Integer oid;
    private String name;
    private User user;
}

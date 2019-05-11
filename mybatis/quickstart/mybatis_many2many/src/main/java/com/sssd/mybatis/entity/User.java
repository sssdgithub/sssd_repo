package com.sssd.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private List<Role> roles;
}

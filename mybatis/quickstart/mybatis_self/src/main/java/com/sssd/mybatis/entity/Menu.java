package com.sssd.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Menu implements Serializable {
    private String mid;
    private String name;
    private String url;
    private String pid;
    private List<Menu> menus;
}

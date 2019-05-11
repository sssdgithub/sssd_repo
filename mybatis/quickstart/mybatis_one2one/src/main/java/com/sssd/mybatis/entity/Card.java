package com.sssd.mybatis.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Card implements Serializable {
    private Integer cid;
    private String cnumber;

}

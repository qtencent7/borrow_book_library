package com.example.springbootdemo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
}

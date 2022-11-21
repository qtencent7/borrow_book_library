package com.example.springbootdemo01.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private String username;
    private  int id;
    private String password;
}

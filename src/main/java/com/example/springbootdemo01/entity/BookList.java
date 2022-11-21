package com.example.springbootdemo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book_list")
public class BookList {
    private Integer id;
    private String name;
    private String author;
    private Integer typeId;
    private String publisher;
    private Integer total;
    private float price;
    private String mark;
    private Integer borrowNum;

}

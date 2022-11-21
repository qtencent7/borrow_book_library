package com.example.springbootdemo01.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book_borrow")
public class Borrow {
    private Integer id;
    private Integer bookId;
    private Integer bookPersonId;
    private String createTime;
    private String borrowTime;
    private String returnTime;
}

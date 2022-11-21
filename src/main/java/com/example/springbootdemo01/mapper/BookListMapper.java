package com.example.springbootdemo01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo01.entity.BookList;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListMapper extends BaseMapper<BookList> {
}

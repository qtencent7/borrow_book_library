package com.example.springbootdemo01.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo01.entity.BookList;
import com.example.springbootdemo01.entity.Borrow;
import com.example.springbootdemo01.mapper.BookListMapper;
import com.example.springbootdemo01.mapper.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookListController {
    @Autowired
    private BookListMapper bookListMapper;

    @Autowired
    private BorrowMapper borrowMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<BookList> list() {
        List<BookList> bookLists = bookListMapper.selectList(null);
        System.out.println("bookLists");
        System.out.println(bookLists);
        return bookLists;
    }

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    @ResponseBody
    public String borrow(@RequestBody Borrow borrow) {

        Integer bookId = borrow.getBookId();
        BookList book = bookListMapper.selectById(bookId);
        System.out.println("book");
        System.out.println(book);
        if(book.getTotal() > 0) {
            borrowMapper.insert(borrow);
            book.setTotal(book.getTotal() - 1);
            book.setBorrowNum(book.getBorrowNum() + 1);
            int i = bookListMapper.updateById(book);
            if(i == 1) {
                return "borrow";
            } else {
                return "borrow error";
            }
        } else {
            return "borrow error";
        }
    }

    @RequestMapping(value="/return", method = RequestMethod.POST)
    @ResponseBody
    public String returnBook(@RequestBody Map<String, Integer> map) {
        if(map.containsKey("id")) {
            Integer id = map.get("id");
            BookList book = bookListMapper.selectById(id);
            if(book.getBorrowNum() > 0) {
                book.setBorrowNum(book.getBorrowNum() - 1);
                book.setTotal(book.getTotal() + 1);
                int i = bookListMapper.updateById(book);
                if(i == 1) {
                    return "return";
                } else {
                    return "return error";
                }
            } else {
                return "return error";
            }
        }
        return "return error";
    }

    @RequestMapping("/test")
    @ResponseBody
    public List test(HttpSession session) {
        Object user = session.getAttribute("user");
        System.out.println("user");
        System.out.println(user);
        QueryWrapper<BookList> queryWrapper= new QueryWrapper<>();
        queryWrapper.between("price", 20, 800);
        List<BookList> list = bookListMapper.selectList(queryWrapper);
        return list;
    }
}

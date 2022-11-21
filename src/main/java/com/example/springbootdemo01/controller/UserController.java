package com.example.springbootdemo01.controller;

import com.example.springbootdemo01.common.JWTTokenUtil;
import com.example.springbootdemo01.entity.User;
import com.example.springbootdemo01.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody User user) {
        System.out.println("user");
        System.out.println(user);
        userMapper.insert(user);
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
        Iterator<User> iterator = users.iterator();
        session.setAttribute("user", username);
        if(iterator.hasNext()) {
            String token = JWTTokenUtil.token(username, password);
            return "login success" + token;
        } else {
            return "login error";
        }
    }


}

package com.example.springbootdemo01;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.springbootdemo01.mapper")
public class Springbootdemo01Application {

    public static void main(String[] args) {

        SpringApplication.run(Springbootdemo01Application.class, args);
        log.info("{} 书城 启动成功 启动端口 {}", "老马", "8080");
    }

}

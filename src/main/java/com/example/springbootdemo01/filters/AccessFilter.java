package com.example.springbootdemo01.filters;


import com.example.springbootdemo01.common.JWTTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
@Order(1)
public class AccessFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/plain;charset=utf-8");
        ServletOutputStream writer = response.getOutputStream();

        String requestURI = request.getRequestURI();

        log.info("拦截到请求： {}", requestURI);

        String[] accessUrls = {
                "/user/login",
                "/user/register",
                "/captcha",
        };
        boolean match = false;
        for(String accessUrl: accessUrls) {
            if(accessUrl.equals(requestURI)) {
                match = true;
            }
        }
        if(match) {
            log.info("本次请求{}无需拦截", requestURI);
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("token");
        if(token == null) {
            response.setContentType("text/plain;charset=utf-8");
            writer.print("未登录");
            writer.close();
            return;
        } else {
            boolean verify = JWTTokenUtil.verify(token);
            if(verify) {
                filterChain.doFilter(request, response);
                return;
            } else {
                writer.print("token不存在");
                writer.close();
                return;
            }
        }
    }
}


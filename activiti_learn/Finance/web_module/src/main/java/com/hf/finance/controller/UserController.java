package com.hf.finance.controller;

import com.hf.finance.entity.permission.User;
import com.hf.finance.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用户Controller
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/19 0019 16:17
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(Integer uid){
        User user = userService.queryUser(uid);
        System.out.println(user);
        return "info";
    }
}

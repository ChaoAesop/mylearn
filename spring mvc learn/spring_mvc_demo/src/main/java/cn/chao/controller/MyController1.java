package cn.chao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/4/16.
 */
@Controller
@RequestMapping("/home")
public class MyController1 {

    @RequestMapping("/say")
    public String say(){
        System.out.println("hello spring mvc!!");
        return "home";
    }
}

package cn.chao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class DemoController1 {

    @RequestMapping("/show")
    public String showinfo(){
        System.out.println("Controller执行");
        return "page/show";
    }
}

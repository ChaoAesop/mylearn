package cn.chao.controller;

import cn.chao.entity.Cursor;
import cn.chao.service.CursorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 查找课程，并显示
 *
 * 通过三种不同的url方式，访问Controller
 */
@Controller
@RequestMapping("/cursor")
public class MyController2 {
    @Resource
    private CursorService cursorService;

    //spring_mvc_demo/cursor/view1.do?cursorId=233
    @RequestMapping(value = "/view1",method = RequestMethod.GET)
    public String cursorView1(@RequestParam("cursorId") Integer cid, Model model){
        System.out.println("cursorId="+cid);
        Cursor cursor = cursorService.getCursorById(cid);
        model.addAttribute("cursor",cursor);
        return "cursor";
    }

    //spring_mvc_demo/cursor/view2/233
    @RequestMapping(value = "/view2/{cursorId}",method = RequestMethod.GET)
    public String cursorView2(@PathVariable("cursorId") Integer cid, Model model){
        System.out.println("cursorId="+cid);
        Cursor cursor = cursorService.getCursorById(cid);
        model.addAttribute("cursor",cursor);
        return "cursor";
    }

    //spring_mvc_demo/cursor/view3?cursorId=233
    @RequestMapping("/view3")
    public String cursorView3(HttpServletRequest request){
        Integer cid = Integer.valueOf(request.getParameter("cursorId"));
        System.out.println("cursorId="+cid);
        Cursor cursor = cursorService.getCursorById(cid);
        request.setAttribute("cursor",cursor);
        return "cursor";
    }
}

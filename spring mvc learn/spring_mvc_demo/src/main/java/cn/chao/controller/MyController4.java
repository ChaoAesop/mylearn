package cn.chao.controller;

import cn.chao.entity.Course2;
import cn.chao.service.CursorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 结合json，返回数据
 */
@Controller
@RequestMapping("/json")
public class MyController4 {

    @Resource
    private CursorService curService;

    //方式一： @ResponseBody返回Json格式， 对应的 @RequestBody接收页面json格式的数据
    @RequestMapping(value = "/{courseId}" ,method = RequestMethod.GET)
    public @ResponseBody Course2 getCourse2InJson(@PathVariable("courseId") Integer courseId){
        return curService.getCoursebyId2(courseId);
    }

    //方式二：
    @RequestMapping(value = "/jsontype/{courseId}" ,method = RequestMethod.GET)
    public ResponseEntity<Course2> getCourse2InJson2(@PathVariable("courseId") Integer courseId){
        Course2 course2 = curService.getCoursebyId2(courseId);
        ResponseEntity responseEntity = new ResponseEntity(course2, HttpStatus.OK);
        return responseEntity;
    }

}

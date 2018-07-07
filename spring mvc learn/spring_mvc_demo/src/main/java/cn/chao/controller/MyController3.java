package cn.chao.controller;

import cn.chao.entity.Course2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 保存课程、跳转页面、重定向、上传文件
 */
@Controller
@RequestMapping("/course2")
public class MyController3 {
    private static Logger log = LoggerFactory.getLogger(MyController3.class);


    //跳转添加页面
    //spring_mvc_demo/course2/admin?add=...
    @RequestMapping(value = "/admin",method = RequestMethod.GET,params = "add")
    public String toAdd(){
        log.info("进入了toAdd...");
        return "course_admin/edit";
    }

    //执行保存，@ModelAttribute接收页面实体数据
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String doSave(@ModelAttribute Course2 course2){
        log.debug("课程信息：");
        log.debug(ReflectionToStringBuilder.toString(course2));
        //在此进行业务操作，比如数据库持久化
        course2.setCourseId(123);
        System.out.println("课程对象："+course2);
        //重定向到controller,对应的转发是forward
        return "redirect:/cursor/view2/233";
    }

    //跳转上传文件页面
    //spring_mvc_demo/course2/upload?multi=true 或 spring_mvc_demo/course2/upload
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String showUploadPage(@RequestParam(value = "multi",required = false) Boolean multi){
        if(multi!=null && multi){
            return "course_admin/multifile";
        }
        return "course_admin/file";
    }

    //执行上传
    //MultipartFile对象封装了上传的文件内容
    @RequestMapping(value = "doUpload",method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            //获得文件名
            String fileName = file.getOriginalFilename();
            log.debug("文件名:{}",fileName);
            InputStream in = file.getInputStream();
            FileUtils.copyInputStreamToFile(in,new File("F:/"+ System.currentTimeMillis()+fileName));
        }
        return "success";
    }


}

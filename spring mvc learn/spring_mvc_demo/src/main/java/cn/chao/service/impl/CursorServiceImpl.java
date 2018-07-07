package cn.chao.service.impl;

import cn.chao.entity.Course2;
import cn.chao.entity.Cursor;
import cn.chao.service.CursorService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/16.
 */
@Service
public class CursorServiceImpl implements CursorService {
    public Cursor getCursorById(Integer cursorId) {
        return new Cursor(1,"语文",33);
    }



    public Course2 getCoursebyId2(Integer courseId) {

        Course2 course = new Course2();

        course.setCourseId(courseId);
        course.setTitle("深入浅出Java多线程");
        course.setImgPath("resources/imgs/course-img.jpg");
        course.setLearningNum(12345);
        course.setLevel(2);
        course.setLevelDesc("中级");
        course.setDuration(7200l);
        course.setDescr("多线程是日常开发中的常用知识，也是难用知识。bala bala...");
        return course;
    }



}

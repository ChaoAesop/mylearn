package cn.chao.service;

import cn.chao.entity.Course2;
import cn.chao.entity.Cursor;

/**
 * Created by Administrator on 2017/4/16.
 */
public interface CursorService {

    public Cursor getCursorById(Integer cursorId);
    public Course2 getCoursebyId2(Integer courseId);
}

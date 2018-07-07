package com.hf.finance.service.impl;

import com.hf.finance.dao.UserDao;
import com.hf.finance.entity.permission.User;
import com.hf.finance.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/19 0019 16:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @Transactional
    public User queryUser(Integer uid) {
        User user = userDao.queryForId(uid);
        return user;
    }
}

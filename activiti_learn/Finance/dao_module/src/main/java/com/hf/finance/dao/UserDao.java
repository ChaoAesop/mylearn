package com.hf.finance.dao;

import com.hf.finance.entity.permission.User;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 11:48
 */
public interface UserDao {
    User queryForId(Integer userId);
}

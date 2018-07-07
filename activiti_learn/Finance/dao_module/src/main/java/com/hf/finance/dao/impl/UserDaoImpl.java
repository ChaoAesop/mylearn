package com.hf.finance.dao.impl;

import com.hf.finance.dao.UserDao;
import com.hf.finance.entity.permission.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 11:32
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    /**
     * 查询实体
     * @param userId
     * @return
     *      查找异常返回Null
     */
    public User queryForId(Integer userId) {
        try{
            return em.find(User.class, userId);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}

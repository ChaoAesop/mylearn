package com.hf.finance.dao.impl;

import com.hf.finance.dao.PermissionDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 15:14
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {
    @PersistenceContext
    private EntityManager em;
}

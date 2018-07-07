package com.hf.finance.dao.impl;

import com.hf.finance.dao.BorrowDao;
import com.hf.finance.entity.form.BorrowForm;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 15:37
 */
@Repository
public class BorrowDaoImpl implements BorrowDao {
    @PersistenceContext
    private EntityManager em;

    public void executeSave(BorrowForm bform) {
        try{
            em.persist(bform);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void executeUpdate(BorrowForm bform) {
        try{
            em.merge(bform);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

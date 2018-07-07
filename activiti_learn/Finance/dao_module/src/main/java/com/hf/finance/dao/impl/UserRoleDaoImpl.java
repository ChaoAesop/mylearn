package com.hf.finance.dao.impl;

import com.hf.finance.dao.UserRoleDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/16 0016 11:03
 */
@Repository
public class UserRoleDaoImpl implements UserRoleDao{

    @PersistenceContext
    private EntityManager em;

    /**
     * 根据用户id查找角色名称
     * @param uid
     * @return
     *      返回多个角色名称，用“，”分割
     */
    public List<Object> findRoleNamesByUid(Integer uid) {
        String hql = "select r.roleName  from UserRole ur inner join Role r on ur.roleId=r.rid where ur.userId="+uid;
        Query query = em.createQuery(hql);

        //角色名字拼接
        StringBuilder names = new StringBuilder();
        return query.getResultList();
    }


}

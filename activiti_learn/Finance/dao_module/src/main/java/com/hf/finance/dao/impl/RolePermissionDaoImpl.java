package com.hf.finance.dao.impl;

import com.hf.finance.dao.RolePermissionDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */
@Repository
public class RolePermissionDaoImpl implements RolePermissionDao {

    @PersistenceContext
    private EntityManager em;

    /**
     * 根据用户，查找权限名
     * @param uid 用户id
     * @return
     *      多个name用","拼接
     */
    public String queryPermissionNames(Integer uid) {
        String sql = "select " +
                "   p.permissionname " +
                "from " +
                "   role_permission rp " +
                "inner join " +
                "   permission p on rp.permissionid=p.pid " +
                "where " +
                "rp.roleid in(" +
                "   select " +
                "     ur.roleid " +
                "   from " +
                "    user_role ur " +
                "      inner join `user` u on ur.userid=u.uid " +
                "   where " +
                "     u.uid=37" +
                ")";
        Query query = em.createNativeQuery(sql);
        List<Object> resultList = query.getResultList();
        StringBuffer bff = new StringBuffer();
        for(int i=0;i<resultList.size();i++){
            // TODO 权限名称字符串拼接
            String pname = resultList.get(i).toString();
            bff.append(pname).append(",");
        }
        return bff.toString();
    }
}

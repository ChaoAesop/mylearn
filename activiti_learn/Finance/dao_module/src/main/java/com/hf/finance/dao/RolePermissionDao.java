package com.hf.finance.dao;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 15:02
 */
public interface RolePermissionDao {

    /**
     * 根据用户，查找权限名
     * @param uid
     * @return
     *      多个name用","拼接
     */
    String queryPermissionNames(Integer uid);

}

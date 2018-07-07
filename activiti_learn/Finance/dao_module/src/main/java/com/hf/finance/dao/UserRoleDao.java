package com.hf.finance.dao;

import java.util.List;

/**
 * 
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 15:02
 */
public interface UserRoleDao {
    /**
     * 根据用户id查找角色id
     * @param uid
     * @return
     */
    List<Object> findRoleNamesByUid(Integer uid);

}

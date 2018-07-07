package com.hf.finance.entity.permission;

import javax.persistence.*;

/**
 * 角色用户关系
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 14:31
 */
@Entity
@Table(name="user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urid")
    private Integer urId;

    @Column(name="userid")
    private Integer userId;

    @Column(name="roleid")
    private Integer roleId;


    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

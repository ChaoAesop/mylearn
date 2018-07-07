package com.hf.finance.entity.permission;

import javax.persistence.*;

/**
 * 权限Entity
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 14:37
 */
@Entity
@Table(name="permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pid")
    private Integer pid;

    @Column(name="permissionname")
    private String permissionName;

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}

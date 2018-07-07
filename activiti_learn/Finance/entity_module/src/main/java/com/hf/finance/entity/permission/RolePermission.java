package com.hf.finance.entity.permission;

import javax.persistence.*;

/**
 * 权限角色
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 14:41
 */
@Entity
@Table(name="role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "urid")
    private Integer rpId;

    @Column(name="roleid")
    private Integer roleId;

    @Column(name="permissionid")
    private Integer permissionId;

    @Override
    public String toString() {
        return "RolePermission{" +
                "rpId=" + rpId +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }

    public Integer getRpId() {
        return rpId;
    }

    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}

package com.hf.finance.entity.permission;

import javax.persistence.*;

/**
 * 角色Entity
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/15 0015 14:33
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer rid;

    @Column(name = "rolename")
    private String roleName;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

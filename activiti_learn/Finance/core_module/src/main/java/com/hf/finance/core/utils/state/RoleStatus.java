package com.hf.finance.core.utils.state;

/**
 * 角色状态
 * Created by LYP on 2016/12/13 0013.
 */
public enum RoleStatus {

    PARTTIME("兼职"),
    PARTNER("合伙人"),
    MANAGE("经理");

    private String name;

    public String getName() {
        return name;
    }

    RoleStatus(String name) {
        this.name = name;
    }
}

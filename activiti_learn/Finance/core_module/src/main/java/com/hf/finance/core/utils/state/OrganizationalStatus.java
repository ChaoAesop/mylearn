package com.hf.finance.core.utils.state;

/**
 * Description 组织架构类型枚举
 * @Author Nelson(mr_caitw@163.com)
 * @Date 2017/5/24 0024 18:01
 */
public enum OrganizationalStatus {
    HEADQUARTERS("总公司"),
    BRANCH("分公司"),
    DEPARTMENT("部门");

    private String name;

    public String getName() {
        return name;
    }

    OrganizationalStatus(String name) {
        this.name = name;
    }
}

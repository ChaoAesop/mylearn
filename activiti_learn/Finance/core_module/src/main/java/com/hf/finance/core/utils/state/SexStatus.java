package com.hf.finance.core.utils.state;

/**
 * 定义性别枚举
 *
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public enum SexStatus {

    W("女"), M("男");

    String name;

    SexStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

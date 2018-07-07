package com.hf.finance.core.utils.state;

/**
 * Description 元素类型枚举
 * @Author Nelson(mr_caitw@163.com)
 * @Date 2017/5/24 0024 18:01
 */
public enum ElementStatus {

    ELEMENT("元素"),
    MENU("菜单");

    private String name;

    public String getName() {
        return name;
    }

    ElementStatus(String name) {
        this.name = name;
    }
}

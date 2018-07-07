package com.hf.finance.core.utils.type;

/**
 * 退订类型
 * Created by LYP on 2017/3/7 0007.
 */
public enum CheckOutTypeEnum {

    AGILE("灵活"),
    MODERATION("适中"),
    RIGID("严格");

    private String name;

    CheckOutTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

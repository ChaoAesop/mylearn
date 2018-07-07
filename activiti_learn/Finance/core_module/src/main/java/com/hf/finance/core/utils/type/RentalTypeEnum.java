package com.hf.finance.core.utils.type;

/**
 * 租售类型
 * Created by LYP on 2017/2/27 0027.
 */
public enum RentalTypeEnum {

    SKILL("一手单"),
    USED_SELL("二手售单"),
    USED_RENT("二手租单");

    private String name;

    public String getName() {
        return name;
    }

    RentalTypeEnum(String name) {
        this.name = name;
    }
}

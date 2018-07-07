package com.hf.finance.core.utils.type;

/**
 * 空间类型
 * Created by LYP on 2017/3/7 0007.
 */
public enum SpaceTypeEnum {
    WHOLE_BUILD("整栋房子"),
    WHOLE_SETS("整套房子"),
    SINGLE("独立单间"),
    BED("床位出租");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SpaceTypeEnum(String name) {
        this.name = name;
    }
}

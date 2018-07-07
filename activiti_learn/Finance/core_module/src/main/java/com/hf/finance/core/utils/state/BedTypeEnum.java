package com.hf.finance.core.utils.state;

/**
 *
 * @Author WZL
 * @Date 2017/6/2 0002 20:53
 */
public enum  BedTypeEnum {
    DOUBLEBED20("2.0双人床"),
    DOUBLEBED18("1.8双人床"),
    DOUBLEBED15("1.5双人床"),
    SINGLEBED("单人床"),
    ROUNDBED("圆床"),
    BABYBED("婴儿床");

    String name;

    BedTypeEnum(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
}

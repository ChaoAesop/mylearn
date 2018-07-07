package com.hf.finance.core.utils.type;

/**
 * 床型
 * Created by clt on 2017/5/26 0026.
 */
public enum BedTypeEnum {

    DOUBLEBED20("2.0米双人床"),
    DOUBLEBED18("1.8米双人床"),
    DOUBLEBED15("1.5米双人床"),
    SINGLEBED("单人床"),
    ROUNDBED("圆床"),
    BADYBED("婴儿床");

    private String name;
    BedTypeEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

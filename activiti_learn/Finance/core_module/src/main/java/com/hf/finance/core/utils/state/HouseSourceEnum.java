package com.hf.finance.core.utils.state;

/**
 * 房源来源
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/6 0006 16:08
 */
public enum HouseSourceEnum {
    SELF("自营"),
    LANDLORD("房东");

    String name;

    HouseSourceEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

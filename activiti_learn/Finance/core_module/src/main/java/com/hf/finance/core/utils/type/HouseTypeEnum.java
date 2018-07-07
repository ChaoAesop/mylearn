package com.hf.finance.core.utils.type;

/**
 * 房屋类型
 * Created by LYP on 2017/3/7 0007.
 */
public enum HouseTypeEnum {
    APARTMENT("公寓住宅"),
    VILLA("别墅洋房"),
    BRAND_VILLA("品牌别墅"),
    SPA_HOUSE("温泉别墅"),
    INN("特色客栈"),
    HOSTEL("民宿"),
    ELSE("其他（帐篷，木屋，房车等）");

    private String name;

    HouseTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

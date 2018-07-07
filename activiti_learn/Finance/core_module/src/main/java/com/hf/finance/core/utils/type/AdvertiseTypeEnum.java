package com.hf.finance.core.utils.type;

/**
 * 广告类型枚举
 * Created by ZCS on 2016/6/1.
 */
public enum AdvertiseTypeEnum {
    // 官网首页广告
    PCHONEPAGE("PCHONEPAGE", "官网首页广告"),
    // 官网新房页面广告
    PCNEWBUILD("PCNEWBUILD", "官网新房页面广告"),
    // 官网APP首页广告
    TftHONEPAGE("TftHONEPAGE", "官网APP首页广告"),
    // 淘房联盟首页广告
    APPADVERTISE("APPADVERTISE", "淘房联盟首页广告"),
    // 淘房联盟新房页面广告
    APPNEWBUILD("APPNEWBUILD", "淘房联盟新房页面广告"),
    // 淘房联盟商学院广告
    APPSCHOOL("APPSCHOOL", "淘房联盟商学院广告");

    AdvertiseTypeEnum(String typeCode, String shortDesc) {
        this.typeCode = typeCode;
        this.shortDesc = shortDesc;
    }

    /**
     * 类型编码
     */
    private String typeCode;

    /**
     * 类型中文描述
     */
    private String shortDesc;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getShortDesc() {
        return shortDesc;
    }
}

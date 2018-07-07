package com.hf.finance.core.utils.state;

/**
 * Description 区域类型枚举
 * @Author Nelson(mr_caitw@163.com)
 * @Date 2017/5/24 0024 18:01
 */
public enum RegionStatus {

    PROVINCE("省"),
    CITY("市"),
    DISTRICTS("县区");

    private String name;

    public String getName() {
        return name;
    }

    RegionStatus(String name) {
        this.name = name;
    }
}

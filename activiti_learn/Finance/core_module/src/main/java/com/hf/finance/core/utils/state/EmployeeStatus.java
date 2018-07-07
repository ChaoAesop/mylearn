package com.hf.finance.core.utils.state;

/**
 * Description 员工状态枚举
 * @Author Nelson(mr_caitw@163.com)
 * @Date 2017/5/24 0024 18:01
 */
public enum EmployeeStatus {
    DISABLE("禁用"),LEAVE("离职"),JOBING("在职");

    String name;

    EmployeeStatus(String name) {
        this.name = name;
    }

    /**
     * 如果对象为空使用默认对象
     *
     * @param object   对象
     * @param nullEnum 为空赋的值
     * @return 对象为空使用默认对象
     */
    public static EmployeeStatus valueOf(Object object, EmployeeStatus nullEnum) {
        return object == null ? nullEnum : EmployeeStatus.valueOf(object.toString());
    }

    public String getName() {
        return name;
    }
}

package com.hf.finance.core.utils.state;

/**
 * 定义YN枚举
 *
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public enum YNStatus {
    Y("是"), N("否");

    String name;

    YNStatus(String name) {
        this.name = name;
    }

    /**
     * 如果对象为空使用默认对象
     *
     * @param object   对象
     * @param nullEnum 为空赋的值
     * @return 对象为空使用默认对象
     */
    public static YNStatus valueOf(Object object, YNStatus nullEnum) {
        return object == null ? nullEnum : YNStatus.valueOf(object.toString());
    }

    public String getName() {
        return name;
    }
}

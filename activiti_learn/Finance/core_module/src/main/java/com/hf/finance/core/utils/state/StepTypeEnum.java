package com.hf.finance.core.utils.state;

/**
 * 步骤枚举
 * @author Administrator
 * @version 1.0
 * @since 1.0
 */
public enum StepTypeEnum {
    SELFHOUSE("自营房源审核"),
    LANDLORDHOUSE("房东房源审核"),
    LEAVE("请假审核");
    String name;

    StepTypeEnum(String name) {
        this.name = name;
    }

    /**
     * 如果对象为空使用默认对象
     *
     * @param object   对象
     * @param nullEnum 为空赋的值
     * @return 对象为空使用默认对象
     */
    public static StepTypeEnum valueOf(Object object, StepTypeEnum nullEnum) {
        return object == null ? nullEnum : StepTypeEnum.valueOf(object.toString());
    }

    public String getName() {
        return name;
    }
}

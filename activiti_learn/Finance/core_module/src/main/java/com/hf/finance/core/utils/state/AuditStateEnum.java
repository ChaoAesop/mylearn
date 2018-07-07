package com.hf.finance.core.utils.state;

/**
 * 审核状态  待审核、通过、不通过
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/2 0002 17:30
 */
public enum AuditStateEnum {
    AUDITING("待审核"),
    PASS("通过"),
    NOPASS("不通过");

    String name;

    AuditStateEnum(String name) {
        this.name = name;
    }

    /**
     * 如果对象为空使用默认对象
     *
     * @param object   对象
     * @param nullEnum 为空赋的值
     * @return 对象为空使用默认对象
     */
    public static AuditStateEnum valueOf(Object object, AuditStateEnum nullEnum) {
        return object == null ? nullEnum : AuditStateEnum.valueOf(object.toString());
    }

    public String getName() {
        return name;
    }
}

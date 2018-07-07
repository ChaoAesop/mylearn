package com.hf.finance.core.utils.state;


/**
 * 收款方式枚举
 * @Author CMC (chao_c_c@163.com)
 * @Date 2017/6/7 0007 19:47
 */
public enum ReceiveWayEnum {
    WECHAT("微信"),
    ALIPAY("支付宝"),
    BANK("银行");

    String name;

    ReceiveWayEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

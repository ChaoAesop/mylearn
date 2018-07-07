package com.hf.finance.core.utils.type;

/**
 * Created by Administrator on 2017-05-26.
 */
public enum OnlinePayTypeEnum {

    WXPAY("微信支付"),
    ALIPAY("支付宝支付");

    private String name;

    OnlinePayTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

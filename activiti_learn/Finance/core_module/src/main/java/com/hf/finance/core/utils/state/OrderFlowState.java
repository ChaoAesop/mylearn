package com.hf.finance.core.utils.state;

/**
 * 日租订单流程状态
 * Created by LYP on 2016/12/28 0028.
 */
public enum OrderFlowState {

    /**
     * 待付款
     */
    OBLIGATION("待付款"),
    /**
     * 已付款
     */
    PAYMENT("已付款"),
    /**
     * 已接单
     */
    RECEIVING("已接单"),
    /**
     * 已入住
     */
    CHECKIN("已入住"),
    /**
     * 已退房
     */
    CANCEL("已退房"),
    /**
     * 已完成
     */
    FINISH("已完成");

    private String name;

    public String getName() {
        return name;
    }

    OrderFlowState(String name) {
        this.name = name;
    }
}

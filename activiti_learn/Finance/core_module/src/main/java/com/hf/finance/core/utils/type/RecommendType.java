package com.hf.finance.core.utils.type;

/**
 * 新闻推荐
 * Created by LYP on 2016/5/25 0025.
 */
public enum RecommendType {
    STICK("置顶"),
    RECOMMEND("推荐"),
    WUSHUXING("无");

    RecommendType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}

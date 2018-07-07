package com.hf.finance.core.utils.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * CollectionUtil 集合工具类
 *
 * @author WJF
 * @since 1.0 2015-11-03
 */
public class CollectionUtil extends CollectionUtils {

    public static void main(String[] args) {

    }
    /**
     * 功能：从List中随机取出一个元素。
     *
     * @param list 源List
     * @return T List的一个元素
     */
    public static <T> T randomOne(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(MathUtil.randomNumber(0, list.size()));
    }
}

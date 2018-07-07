package com.hf.finance.core.utils.util;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

/**
 * MathUtil 工具类
 *
 * @author WJF
 * @date 2015-11-03
 * @since 1.0
 */
public class MathUtil extends NumberUtils {

    /**
     * 功能：将字符串转换为BigDecimal，一般用于数字运算时。
     *
     * @param str 字符串
     * @return BigDecimal, str为empty时返回null。
     * @date 2014年06月25日
     */
    public static BigDecimal toBigDecimal(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        return new BigDecimal(str);
    }

    /**
     * 返回两个double的商 first除以second。
     *
     * @param first  第一个double
     * @param second 第二个double
     * @return double
     * @date 2014年06月25日
     */
    public static double divideDouble(double first, double second) {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.divide(b2).doubleValue();
    }

    /**
     * 返回两个double的乘积 first*second。
     *
     * @param first  第一个double
     * @param second 第二个double
     * @return double
     * @date 2014年06月25日
     */
    public static double multiplyDouble(double first, double second) {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 返回两个double的差值 first-second。
     *
     * @param first  第一个double
     * @param second 第二个double
     * @return double
     * @date 2014年06月25日
     */
    public static double subtractDouble(double first, double second) {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 返回两个double的和值 first+second。
     *
     * @param first  第一个double
     * @param second 第二个double
     * @return double
     * @date 2014年06月25日
     */
    public static double sumDouble(double first, double second) {
        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal(second);
        return b1.add(b2).doubleValue();
    }

    /**
     * 格式化double指定位数小数。例如将11.123格式化为11.1。
     *
     * @param value    原double数字。
     * @param decimals 小数位数。
     * @return 格式化后的double，注意为硬格式化不存在四舍五入。
     * @date 2014年06月25日
     */
    public static String formatDouble(double value, int decimals) {
        String doubleStr = "" + value;
        int index = doubleStr.indexOf(".") != -1 ? doubleStr.indexOf(".")
                : doubleStr.indexOf(",");
        // Decimal point can not be found...  
        if (index == -1)
            return doubleStr;
        // Truncate all decimals  
        if (decimals == 0) {
            return doubleStr.substring(0, index);
        }
        int len = index + decimals + 1;
        if (len >= doubleStr.length())
            len = doubleStr.length();
        double d = Double.parseDouble(doubleStr.substring(0, len));
        return String.valueOf(d);
    }

    /**
     * 生成一个指定位数的随机数，并将其转换为字符串作为函数的返回值。
     *
     * @param numberLength 随机数的位数。
     * @return String 注意随机数可能以0开头。
     * @date 2014年06月25日
     */
    public static String randomNumber(int numberLength) {
        // 记录生成的每一位随机数  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberLength; i++) {
            // 每次生成一位,随机生成一个0-10之间的随机数,不含10。  
            Double ranDouble = Math.floor(Math.random() * 10);
            sb.append(ranDouble.intValue());
        }
        return sb.toString();
    }

    /**
     * 功能：生成一个在最大数和最小数之间的随机数。会出现最小数，但不会出现最大数。
     *
     * @param minNum 最小数
     * @param maxNum 最大数
     * @return int
     * @date 2014年06月25日
     */
    public static int randomNumber(int minNum, int maxNum) {
        if (maxNum <= minNum) {
            throw new RuntimeException("maxNum必须大于minNum!");
        }
        // 计算出来差值  
        int subtract = maxNum - minNum;
        Double ranDouble = Math.floor(Math.random() * subtract);
        return ranDouble.intValue() + minNum;
    }

    /**
     * 功能：生成一个在最大数和最小数之间的随机数。会出现最小数，但不会出现最大数。<br/>
     * 但不随机notin数组中指定的数字， 如果可随机的范围较小，可能会一直随机不到，或者随机的很慢。
     *
     * @param minNum 最小数
     * @param maxNum 最大数
     * @param notin  不随机数组这些数字
     * @return int
     * @date 2014年06月25日
     */
    public static int randomNumber(int minNum, int maxNum, Integer[] notin) {
        if (notin.length >= (maxNum - minNum)) {
            throw new RuntimeException("notin数组的元素已经把可以随机的都排除了，无法得到随机数!");
        }
        while (true) {
            int num = randomNumber(minNum, maxNum);
            if (!ArrayUtil.arrayContain(notin, num)) {
                return num;
            }
        }
    }
}

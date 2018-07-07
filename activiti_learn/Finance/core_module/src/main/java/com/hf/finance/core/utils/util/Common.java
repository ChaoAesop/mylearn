package com.hf.finance.core.utils.util;


import com.hf.finance.core.utils.state.SystemCodeStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>Title: Common   </p>
 * <p>Description: 公共类，保存系统各种通用方法</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company: SchoolService</p>
 * <p>Create Date/Time: 2014-6-9 下午4:17:16</p>
 *
 * @author Joe Zhou
 * @version 1.0
 */
public class Common {

    private Common() {
    }


    private static Common common = new Common();

    public static Common getCommon() {
        return common;
    }

    /**
     * 根据名字获取对应name的cookie的值
     *
     * @param request HttpServletRequest对象
     * @param name    cookie key 值
     * @return Map
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = getCookie(request, name);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }


    /**
     * 根据名字获取对应的cookie对象
     *
     * @param request HttpServletRequest对象
     * @param name    cookie key 值
     * @return Map
     */
    public static Cookie getCookie(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieToMap(request);
        return cookieMap.containsKey(name) ? cookieMap.get(name) : null;
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request HttpServletRequest对象
     * @return Map
     */
    private static Map<String, Cookie> readCookieToMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (ArrayUtil.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    // 生成6位公司编码
    public static String getSix(int serial) {
        String strSerial = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String date = sdf.format(new Date());
        if (serial < 10) {
            strSerial = "" + date + "" + "000" + "" + serial + "";
        } else if (serial >= 10 && serial < 100) {
            strSerial = "" + date + "" + "00" + "" + serial + "";
        } else if (serial >= 100 && serial < 1000) {
            strSerial = "" + date + "" + "0" + "" + serial + "";
        } else if (serial >= 1000 && serial < 10000) {
            strSerial = "" + date + "" + "" + "" + serial + "";
        }
        return strSerial;
    }



    /**
     * 返回UUID
     *
     * @return String
     */
    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 返回结果集
     *
     * @param stateCode 状态代码 200、500、502
     * @param obj       数据
     * @param message   信息
     * @return Map
     */
    public static Map<String, Object> resultMap(int stateCode, Object obj, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", stateCode);
        map.put("data", obj);
        map.put("message", message);
        return map;
    }

    /**
     * 返回的消息
     *
     * @param status  SystemCodeStatus的数据
     * @param message 返回的消息
     * @return Map
     */
    public static Map<String, Object> resultMap(int status, String message) {
        return Common.resultMap(status, "", message);
    }

    /**
     * 返回查找数据为空
     *
     * @return Map
     */
    public static Map<String, Object> resultNullData() {
        return Common.resultMap(SystemCodeStatus.NULL_DATA, "", "查找数据为空");
    }

    /**
     * 返回的数据
     *
     * @param data 返回的数据
     * @return Map
     */
    public static Map<String, Object> resultSuccessMap(Object data) {
        return Common.resultMap(SystemCodeStatus.SUCCESS, data, "");
    }

    /**
     * 参数不全返回数据
     *
     * @return Map
     */
    public static Map<String, Object> resultNullParameter() {
        return Common.resultMap(SystemCodeStatus.NULL_PARAMETER, "参数不全");
    }

    /**
     * 数据被删除时
     * 操作数据时调用
     *
     * @return Map
     */
    public static Map<String, Object> resultLoginFailure() {
        return Common.resultMap(SystemCodeStatus.RECORD_EMPTY, "账号失效，请重新登录");
    }

    /**
     * 记录为空返回数据
     *
     * @return Map
     */
    public static Map<String, Object> resultEmptyRecord() {
        return Common.resultMap(SystemCodeStatus.RECORD_EMPTY, "数据为空,请刷新");
    }

    /**
     * 返回grid的map格式数据
     *
     * @param obj   需要转换的数据
     * @param total 总数据条数
     * @return
     */
    public Map<String, Object> getGridMap(Object obj, int total) {
        Map<String, Object> map = new HashMap<>();
        map.put("Rows", obj);
        map.put("Total", total);
        return map;
    }

    /**
     * 对两个实体类属性值进行并集
     *
     * @param t1 被修改的实体类
     * @param t2 修改的实体类
     * @return
     */
    public <T> T extend(T t1, T t2) {
        Field[] fields1 = t1.getClass().getDeclaredFields();
        Field[] fields2 = t2.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields1.length; i++) {
                fields1[i].setAccessible(true);
                fields2[i].setAccessible(true);
                if (fields2[i].get(t2) != null && !fields2[i].get(t2).equals(fields1[i].get(t1)))
                    fields1[i].set(t1, fields2[i].get(t2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t1;
    }

    /**
     * 金额大写转换
     *
     * @param digit
     * @return String
     */
    public String toUpper(double digit) {
        //将数据格式化为四位小数
        DecimalFormat df = new DecimalFormat("#.0000");
        StringBuffer sbDigit = new StringBuffer(df.format(digit));
        sbDigit.replace(sbDigit.length() - 2, sbDigit.length(), "00");
        String sDigit = "";//将double转化为string
        sDigit = sbDigit.toString();
        sDigit = sDigit.substring(0, sDigit.length() - 5) + sDigit.substring(sDigit.length() - 4);//去除小数点

        //将字符串补齐16位，利于分组
        //sDigit = sDigit + "00";
        if (sDigit.length() > 16) {
            return "款项过大！";
        }
        if (sDigit.length() < 16) {
            int iLength = 16 - sDigit.length();
            for (int i = 0; i < iLength; i++) {
                sDigit = "0" + sDigit;
            }
        }
        if (sDigit.equals("0000000000000000")) {
            return "零圆整";
        }
        String sChinese = sDigit;
        String sFour = "";//每四位构造一个string
        boolean bPreStr = true;//前一个string是否构造成功
        sDigit = "";//总字符串
        //将字符串分为四组，每一组单独处理，都处理完后串接
        for (int i = 0; i < 4; i++) {
            sFour = toChinese(sDigit, sChinese.substring(i * 4, i * 4 + 4), i, bPreStr);
            if (sFour.length() == 0 || sFour.length() == 1) {
                bPreStr = false;
            } else if (sFour.charAt(sFour.length() - 2) < '0' || sFour.charAt(sFour.length() - 2) > '9') {
                bPreStr = false;
            } else {
                bPreStr = true;
            }
            sDigit = sDigit + sFour;
        }
        //去掉字符串最前面的‘0’
        for (; ; ) {
            if (sDigit.charAt(0) == '0') {
                sDigit = sDigit.substring(1);
            } else {
                break;
            }
        }

        sChinese = "";
        for (int i = 0; i < sDigit.length(); i++) {
            if (sDigit.charAt(i) >= '0' && sDigit.charAt(i) <= '9') {
                switch (sDigit.charAt(i)) {
                    case '1': {
                        sChinese = sChinese + "壹";
                        break;
                    }
                    case '2': {
                        sChinese = sChinese + "贰";
                        break;
                    }
                    case '3': {
                        sChinese = sChinese + "叁";
                        break;
                    }
                    case '4': {
                        sChinese = sChinese + "肆";
                        break;
                    }
                    case '5': {
                        sChinese = sChinese + "伍";
                        break;
                    }
                    case '6': {
                        sChinese = sChinese + "陆";
                        break;
                    }
                    case '7': {
                        sChinese = sChinese + "柒";
                        break;
                    }
                    case '8': {
                        sChinese = sChinese + "捌";
                        break;
                    }
                    case '9': {
                        sChinese = sChinese + "玖";
                        break;
                    }
                    case '0': {
                        sChinese = sChinese + "零";
                        break;
                    }
                }
            } else {
                sChinese = sChinese + sDigit.charAt(i);
            }
        }
        if (!sDigit.endsWith("分")) {//有"分"不加"整"
            sChinese = sChinese + "整";
        }
        return sChinese;
    }

    /**
     * 内置方法：用来验证数据
     *
     * @param sStr  总字符串
     * @param sFour 需要分析的字符串
     * @param i     第i次调用本方法
     * @param bPre  前一次调用时是否成功
     * @return 回传结果
     */
    private String toChinese(String sStr, String sFour, int i, boolean bPre) {
        String sStruct = "";//回传结果
        for (int j = 0; j < 4; j++) {
            if (sFour.charAt(j) != '0') {//处理每一位数值时，在前面是否需要加“零”
                if (j == 0) {//处理千位
                    if (!bPre) {
                        sStruct = sStruct + '0';
                    }
                    sStruct = sStruct + sFour.charAt(j);
                } else {//处理百、十、个位
                    if (sFour.charAt(j - 1) == '0') {
                        sStruct = sStruct + '0';
                    }
                    sStruct = sStruct + sFour.charAt(j);
                }
                switch (j) {//单独处理“角”和“分”
                    case 0: {
                        if (i == 3) {
                            sStruct = sStruct + "角";
                        } else {
                            sStruct = sStruct + "仟";
                        }
                        break;
                    }
                    case 1: {
                        if (i == 3) {
                            sStruct = sStruct + "分";
                        } else {
                            sStruct = sStruct + "佰";
                        }
                        break;
                    }
                    case 2: {
                        sStruct = sStruct + "拾";
                        break;
                    }
                    case 3: {
                        if (!sStruct.equals("")) {
                            switch (i) {//处理单位
                                case 0: {
                                    sStruct = sStruct + "亿";
                                    break;
                                }
                                case 1: {
                                    sStruct = sStruct + "万";
                                    break;
                                }
                                case 2: {
                                    sStruct = sStruct + "圆";
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {//当个位为零时，处理单位
                if (!sStruct.equals("") && j == 3) {
                    switch (i) {
                        case 0: {
                            sStruct = sStruct + "亿";
                            break;
                        }
                        case 1: {
                            sStruct = sStruct + "万";
                            break;
                        }
                    }
                }
                if (i == 2 && j == 3 && (!sStr.equals("") || !sStruct.equals(""))) {//是否加“圆”字
                    sStruct = sStruct + "圆";
                }
            }
        }
        return sStruct;
    }

}

package com.hf.finance.core.utils.util;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * MapUtil map工具类
 *
 * @author WJF
 * @Package com.taofangt.utils
 * @Date 2016-03-24 下午 5:18
 */
public class MapUtil extends MapUtils {

    /**
     * 处理过滤 请求参数为空的数据
     *
     * @param map
     */
    @Deprecated
    public static Map<String, Object> removeValueEmpty(Map<String, String[]> map) {
        Map<String, Object> map1 = new HashMap<>();
        if (map != null) {
            Iterator<Map.Entry<String, String[]>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String[]> entry = iterator.next();
                if (entry.getValue() == null
                        || entry.getValue().length == 0
                        || StringUtil.isEmpty(entry.getValue()[0])
                        || entry.getValue()[0].equals("undefined")
                        || entry.getValue()[0].equals("[]")
                        || entry.getValue()[0].equals("null")) {
                    iterator.remove();
                } else {
                    map1.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }
        return map1;
    }

    public static Boolean checkAllDataNotEmpty(Map map, Object... objects) throws NullPointerException {
        for (Object object : objects) {
            if (!map.containsKey(object)) {
                throw new NullPointerException(StringUtil.toString(object));
            }
        }
        return true;
    }

    /**
     * 获取原map中对应的key值(存在的就赋值)
     *
     * @param source 原始map
     * @param keys   赋值的key
     * @return map 目标map
     */
    public static Map get(Map source, Object... keys) {
        Map target = new HashMap<>();
        for (Object key : keys) {
            source.computeIfPresent(key, (k, v) -> target.put(k, v));
        }
        return target;
    }

    /**
     * 获取全部的key, 没有抛异常提示有数据为空(复制key里面全部的key中的value)
     *
     * @param source 原始map
     * @param keys   赋值的key
     * @return Map 目标map
     * @throws NullPointerException 存在数据为空抛异常
     */
    public static Map getAllKey(Map source, Object... keys) throws NullPointerException {
        Map target = new HashMap<>();
        for (Object key : keys) {
            if (!source.containsKey(key)) {
                throw new NullPointerException(StringUtil.toString(key));
            }
            target.put(key, source.get(key));
        }
        return target;
    }

    /**
     * 删除map中多余的字段，返回到前台
     *
     * @param mapList 要处理的集合对象
     * @param keys    要删除的key
     */
    public static void remove(List<Map> mapList, Object... keys) {
        if (CollectionUtil.isNotEmpty(mapList)) {
            mapList.forEach((map) -> MapUtil.remove(map, keys));
        }
    }

    /**
     * 删除map中多余的字段，数据返回到前台
     *
     * @param map  要处理的map对象
     * @param keys 要删除的key
     */
    public static void remove(Map map, Object... keys) {
        if (MapUtils.isNotEmpty(map)) {
            for (Object key : keys) {
                map.computeIfPresent(key, (num, val) -> null);
            }
        }
    }

    /**
     * map.get() 数据为空
     *
     * @param map
     * @param object
     * @return
     */
    public static Boolean isEmpty(Map map, Object object) {
        return !MapUtil.isNotEmpty(map, object);
    }

    /**
     * map.get() 数据不为为空
     *
     * @param object
     * @return
     */
    public static Boolean isNotEmpty(Map map, Object object) {
        return MapUtils.isNotEmpty(map) && map.containsKey(object);
    }
}

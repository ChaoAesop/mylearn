package com.hf.finance.core.utils.type;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析实体成一二级树形结构数据
 * @Author kreey.wu CMC Nelson
 * @Date 2017/5/18 0018 11:45
 */
public class TreeUtil2<T> {

    //所有数据的缓存集合
    private List<T> dataList = new ArrayList<T>();
    //实体对象
    private Class clazz;
    //实体主键字段的名称
    private String pk;
    //实体显示字段的名称
    private String name;
    //实体父主键字段的名称
    private String ppk;

    /**
     * 参数描述
     * @param entityClass 类类型
     * @param list 所有集合数据
     * @param pk 实体主键字段名称
     * @param ppk 实体父主键字段名称
     */
    public TreeUtil2(Class<T> entityClass, List<T> list, String pk, String name, String ppk){
        this.dataList = list;
        this.clazz = entityClass;
        this.pk = pk;
        this.name = name;
        this.ppk= ppk;
    }

    /**
     * 解析生成Tree结构数据
     * @return
     */
    public List<Map<Object,Object>> generateEntity(){
        List<Map<Object,Object>> result = new ArrayList<Map<Object,Object>>();
        for (T temp: dataList) {
            Object fieldValue = getFieldValue(temp, ppk);
            if (fieldValue==null || "".equals(fieldValue.toString())) {
                Map<Object,Object> dataMap = new HashMap<Object,Object>();
                List<T> children = new ArrayList<T>();
                Object nowpk = getFieldValue(temp, pk);
                for (T temp2 : dataList ) {
                    Object fieldValue2 = getFieldValue(temp2, ppk);
                    if (fieldValue2!=null && fieldValue2.toString().equals(nowpk)) {
                        children.add(temp2);
                    }
                }
                dataMap.put(temp, children);
                result.add(dataMap);
            }
        }
        return result;
    }

    /**
     * 根据实体和字段名称，获取字段的值
     * @param entity 实体
     * @param fieldName 字段名
     * @return
     */
    private Object getFieldValue(T entity, String fieldName){
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package cn.chao.test;

import cn.chao.poi.ExcelDataConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9 0009.
 */
public class PoiTest {
    public static void main(String[] args) throws Exception {
        String filePath = "excel\\员工工资数据表.xls";//excel\员工工资数据表.xls
        long start = System.currentTimeMillis();
        ExcelDataConverter excel = new ExcelDataConverter(filePath);
        List<Object[]> objectData = excel.getObjectData();
        long end = System.currentTimeMillis();
        for(Object[] objs : objectData){
            System.out.println(Arrays.toString(objs));
        }
        System.out.println("总用时："+(end-start)/1000.0+" 秒");
        System.out.println("总条目："+objectData.size());
    }
}

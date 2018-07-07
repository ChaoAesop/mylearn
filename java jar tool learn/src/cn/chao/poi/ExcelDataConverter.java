package cn.chao.poi;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Excel批量导入
 */
public class ExcelDataConverter {
    private Workbook wbook;

    public ExcelDataConverter(String filePath) {
        //初始化工作簿
        initialWorkBook(filePath);
    }

    /**
     * 获取解析的数据集
     * @return
     */
    public List<Object[]> getObjectData() {
        List<Object[]> data = new ArrayList<Object[]>();
        if (wbook == null) {
            return null;
        }
        //得到一个工作表
        Iterator<Sheet> sheetIterator = wbook.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();


            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            for (int i = 0; i < totalRowNum + 1; i++) {
                Row row = sheet.getRow(i);
                if (row == null || isRowEmpty(row)) {
                    continue;
                }
                //行数据
                // TODO 测试
                //System.out.println("  lastCellNum:"+row.getLastCellNum());
                Object[] objs = new Object[row.getLastCellNum()];
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);

                    // TODO 单元格类型处理
                    if (cell == null) {
                        objs[j] = "";
                    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        //日期类型处理 和 数字类型的处理
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", LocaleUtil.getUserLocale());
                            sdf.setTimeZone(LocaleUtil.getUserTimeZone());
                            objs[j] = sdf.format(cell.getDateCellValue());
                        } else {
                            objs[j] = String.valueOf(cell.getNumericCellValue());
                        }
                    } else {
                        //其他类型
                        objs[j] = cell.toString();
                    }
                }
                //添加一行数据
                data.add(objs);
            }
        }
        return data;
    }

    private void initialWorkBook(String filePath) {
        FileInputStream fis = null;

        if (filePath.endsWith(".xls")) {
            //2003版本的excel，用.xls结尾
            try {
                fis = new FileInputStream(filePath);
                wbook = new HSSFWorkbook(fis);//得到工作簿
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (filePath.endsWith(".xlsx")) {
            //2007版本的excel，用.xlsx结尾
            try {
                fis = new FileInputStream(filePath);
                wbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("该文件不是excel类型！");
        }
    }

    private static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
                return false;
        }
        return true;
    }
}

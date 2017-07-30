package com.twg.util;

/**
 * Created by tenvin on 2017/7/25.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twg.entity.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class ParseExcel {

    private static POIFSFileSystem fs;
    private static HSSFWorkbook wb;
    private static HSSFSheet sheet;
    private static HSSFRow row;

    /**
     * @describe 解析excel表头
     * @date 2017年5月20日
     * @author liukang
     */
    public static String[] readExcelTitle(InputStream stream) {

        try {
            fs = new POIFSFileSystem(stream);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;

    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private static String getStringCellValue(HSSFCell cell) {
        String strCell = "";
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        return strCell;
    }

    private static String getDateCellValue(HSSFCell cell) {
        String result = "";
        try {
            int cellType = cell.getCellType();
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                Date date = cell.getDateCellValue();
                result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
                        + "-" + date.getDate();
            } else if (cellType == HSSFCell.CELL_TYPE_STRING) {
                String date = getStringCellValue(cell);
                result = date.replaceAll("[年月]", "-").replace("日", "").trim();
            } else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
                result = "";
            }
        } catch (Exception e) {
            System.out.println("日期格式不正确!");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据HSSFCell类型设置数据
     *
     * @param cell
     * @return
     */
    private static String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static List<Score> readExcelContentForScore(InputStream is) throws Exception {
        fs = new POIFSFileSystem(is);
        wb = new HSSFWorkbook(fs);
        List<Score> scores = new ArrayList<Score>();

        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        //获取头信息
        row = sheet.getRow(0);
        //获取总列数
        int colNum = row.getPhysicalNumberOfCells();

        Score score = null;
        for (int i = 1; i <= rowNum; i++) {
            score = new Score();
            row = sheet.getRow(i);
            score.setXueqi(new Xueqi(getCellFormatValue(row.getCell(0))));
            score.setZhuanye(new Zhuanye(getCellFormatValue(row.getCell(1))));
            score.setBanji(new Banji(getCellFormatValue(row.getCell(2))));
            score.setStudent(new Student(getCellFormatValue(row.getCell(3))));
            score.setKemu(new Kemu(getCellFormatValue(row.getCell(4))));
            score.setFenshu(Float.parseFloat(getCellFormatValue(row.getCell(5))));

            scores.add(score);
            score = null;
        }
        return scores;
    }

    /**
     * 读取Excel数据内容
     */
    public static Map<Integer, String> readExcelContent(InputStream is) {
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                str = str + getCellFormatValue(row.getCell(j)) + " ";
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }

    public static void main(String[] args) {
        try {
            // 对读取Excel表格标题测试
            InputStream is = new FileInputStream("d:\\test2.xls");

            String[] title = ParseExcel.readExcelTitle(is);
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
            }


//            // 对读取Excel表格内容测试
//            InputStream is2 = new FileInputStream("d:\\test2.xls");
//            Map<Integer, String> map = ParseExcel.readExcelContent(is2);
//            System.out.println("/n获得Excel表格的内容:");
//            for (int i = 1; i <= map.size(); i++) {
//                System.out.println(map.get(i));
//            }

            InputStream is2 = new FileInputStream("d:\\test2.xls");
            List<Score> scores = ParseExcel.readExcelContentForScore(is2);

            System.out.println("/n获得Excel表格的内容:");
            for(Score score:scores){
                System.out.println("score="+score);
            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


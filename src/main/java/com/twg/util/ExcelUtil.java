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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;



public class ExcelUtil {

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

//    public List<CourseType> readExcelContentForStudentScore(InputStream is) throws Exception {
//        fs = new POIFSFileSystem(is);
//        wb = new HSSFWorkbook(fs);
//        List<CourseType> courseTypes = new ArrayList<CourseType>(7);
//    	/*
//    	 * 由于wb中获取了所有的sheet信息, 为了加快效率, 在该方法中进行统一分析处理
//    	 * 1、只处理偶数sheet(每一科的单科成绩)
//    	 * 		化学、历史、数学、物理、英语、语文、政治(0 2 4 6 8 10 12)
//    	 */
//        //1、获取第0个sheet并处理(化学)
//        for (int sheetIndex = 0; sheetIndex <= 12; sheetIndex = sheetIndex+2) {
//            sheet = wb.getSheetAt(sheetIndex);
//            // 得到总行数
//            int rowNum = sheet.getLastRowNum();
//            //获取头信息
//            row = sheet.getRow(2);
//            int colNum = row.getPhysicalNumberOfCells();
//            String[] titleStr = new String[colNum-1-8];
//            for (int index = 8; index < colNum-1; index++) {
//                titleStr[index - 8] = row.getCell(index).getStringCellValue();
//            }
//            CourseType courseType = new CourseType();
//            switch (sheetIndex) {
//                case 0:
//                    courseType.setCourseName("");break;
//                case 2:
//                    courseType.setCourseName("");break;
//                case 4:
//                    courseType.setCourseName("");break;
//                case 6:
//                    courseType.setCourseName("");break;
//                case 8:
//                    courseType.setCourseName("");break;
//                case 10:
//                    courseType.setCourseName("");break;
//                case 12:
//                    courseType.setCourseName("");break;
//                default:
//                    break;
//            }
//            Set<ScoreEntity> scoreEntities = new HashSet<ScoreEntity>();
//            for (int i = 3; i <= rowNum; i++) {
//                ScoreEntity scoreEntity = new ScoreEntity();
//                row = sheet.getRow(i);
//                int j = 0;
//                //获取总列数(32列)
//                colNum = row.getPhysicalNumberOfCells();
//                ProjectUser projectUser = new ProjectUser();
//                projectUser.setExamineeNumber(row.getCell(j++).getStringCellValue());						//考号
//                projectUser.setName(row.getCell(j++).getStringCellValue());						//学生姓名
//                scoreEntity.setProjectUser(projectUser);
//                //暂时不用班级
//                row.getCell(j++).getStringCellValue();					//班级名
//                scoreEntity.setScoreTotalVal(row.getCell(j++).getNumericCellValue());//总分
//                scoreEntity.setClassRank((int)row.getCell(j++).getNumericCellValue());		//班级排名
//                scoreEntity.setGradeRank((int)row.getCell(j++).getNumericCellValue());		//学校排名
//                scoreEntity.setObjectiveItemVal(Double.parseDouble(row.getCell(j++).getStringCellValue()));//客观成绩
//                scoreEntity.setSubjectiveItemVal(Double.parseDouble(row.getCell(j++).getStringCellValue()));//主观成绩
//                //开始构造成绩项信息
//                Set<ScoreItem> items = new HashSet<ScoreItem>();
//                for (int k = 0, len = titleStr.length; k < len; k++) {
//                    ScoreItem scoreItem = new ScoreItem();
//                    scoreItem.setItemName(titleStr[k]);
//                    scoreItem.setScoreVal(row.getCell(j++).getNumericCellValue());
//                    items.add(scoreItem);
//                }
//                scoreEntity.setItems(items);
//                scoreEntities.add(scoreEntity);
//            }
//            courseType.setScoreEntities(scoreEntities);
//            courseTypes.add(courseType);
//        }
//        //2、处理第2个sheet并处理(历史)
///*    	{
//    		sheet = wb.getSheetAt(2);
//    		// 得到总行数
//	    	int rowNum = sheet.getLastRowNum();
//	    	//获取头信息
//	    	row = sheet.getRow(2);
//	    	int colNum = row.getPhysicalNumberOfCells();
//	    	String[] titleStr = new String[colNum-1-8];
//	    	for (int index = 8; index < colNum-1; index++) {
//	    		titleStr[index - 8] = row.getCell(index).getStringCellValue();
//	    	}
//	    	CourseType courseType = new CourseType();
//	    	courseType.setCourseName("历史");
//	    	Set<ScoreEntity> scoreEntities = new HashSet<ScoreEntity>();
//	    	for (int i = 3; i <= rowNum; i++) {
//
//	    	}
//    	}*/
//        return courseTypes;
//    }
//
//    public List<ProjectUser> readExcelContentForStudentTab(InputStream is) throws Exception {
//        fs = new POIFSFileSystem(is);
//        wb = new HSSFWorkbook(fs);
//        sheet = wb.getSheetAt(0);
//        // 得到总行数
//        int rowNum = sheet.getLastRowNum();
//        row = sheet.getRow(0);
//        //int colNum = row.getPhysicalNumberOfCells();
//        // 正文内容应该从第二行开始,第一行为表头的标题
//        //Object[][] objs = new Object[rowNum][3];
//        ArrayList<ProjectUser> arrayList = new ArrayList<ProjectUser>();
//        for (int i = 1; i <= rowNum; i++) {
//            ProjectUser projectUser = new ProjectUser();
//            //获取第i行数据
//            row = sheet.getRow(i);
//            int j = 0;
//            //对列进行读取解析
//            String stuNo = row.getCell(j++).getStringCellValue();				//学号
//            String stuName = row.getCell(j++).getStringCellValue();				//姓名
//            String stuExamNo = row.getCell(j++).getStringCellValue();			//准考证号
//            String grade = row.getCell(j++).getStringCellValue();				//学号
//            String className = row.getCell(j++).getStringCellValue();			//学号
//            String schoolName = row.getCell(j++).getStringCellValue();			//学号
//            String isTransientStu = row.getCell(j++).getStringCellValue();		//是否借读
//            String subjectType = row.getCell(j++).getStringCellValue();			//科目类型
//            String sex = row.getCell(j++).getStringCellValue();					//性别
//            String point = row.getCell(j++).getStringCellValue();				//学号
//            String examPlace = row.getCell(j++).getStringCellValue();			//学号
//            //String stuPwd = row.getCell(j++).getStringCellValue();			//学号
//            //String parentPwd = row.getCell(j++).getStringCellValue();			//学号
//            //构造对象
//            //1、学生对象
//            //设置
//            projectUser.setPwd("111111");
//            projectUser.setLoginName(stuExamNo);
//            projectUser.setUserType(1);
//
//            projectUser.setUserNo(stuNo);
//            projectUser.setName(stuName);
//            projectUser.setSex(Integer.parseInt(sex));
//            projectUser.setExamineeNumber(stuExamNo);
//            projectUser.setIsTransientStu(Integer.parseInt(isTransientStu));
//            projectUser.setSubjectType(subjectType);
//            //2、构造班级对象
//            StudentClass studentClass = new StudentClass();
//            studentClass.setClassName(className);
//            studentClass.setGradeName(grade);
//            studentClass.setSchoolName(schoolName);
//            projectUser.setStudentClass(studentClass);
//            //构造考场对象
//            ExamPlaceEntity examPlaceEntity = new ExamPlaceEntity();
//            examPlaceEntity.setExamPlaceName(examPlace);
//            examPlaceEntity.setExamPoint(point);
//            projectUser.setExamPlace(examPlaceEntity);
//            //将学生放入学生集合
//            arrayList.add(projectUser);
//        }
//        return arrayList;
//    }

    /**
     * 读取Excel数据内容
     *
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
                str = str + getCellFormatValue(row.getCell(j))+" ";
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

            String[] title = ExcelUtil.readExcelTitle(is);
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
            }


            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream("d:\\test2.xls");
            Map<Integer, String> map = ExcelUtil.readExcelContent(is2);
            System.out.println("/n获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }
}


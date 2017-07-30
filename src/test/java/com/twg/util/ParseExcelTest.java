package com.twg.util;

import com.twg.entity.Score;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tenvin on 2017/7/30.
 */
public class ParseExcelTest {
    @Test
    public void readExcelContentForScore() throws Exception {
        try {
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
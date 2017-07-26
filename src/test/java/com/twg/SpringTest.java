package com.twg;

import com.twg.entity.Student;
import com.twg.service.StudentService;
import com.twg.util.ExcelUtil;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by tenvin on 2017/7/26.
 */
public class SpringTest {
    private ApplicationContext ctx = null;
    private StudentService studentService = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        studentService = ctx.getBean(StudentService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("teatDown");
    }

    @Test
    public void EntityManagerTest(){

    }

    @Test
    public void testStudentSave(){

        Student student = null;
        for(int i =0;i<10;i++){
            student = new Student();
            student.setName("test"+i);
            studentService.save(student);
        }
    }

    @Test
    public void testFindByName(){
        String name = "test0";
        Student student = studentService.findByName(name);
        System.out.println(student);
    }

    @Test
    public void testExcelImport(){
        InputStream is = null;
        try {
            //1.读excel文件
            is = new FileInputStream("d:\\test2.xls");

            Map<Integer, String> map = ExcelUtil.readExcelContent(is);

            //2.解析
            POIFSFileSystem fs = new POIFSFileSystem(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

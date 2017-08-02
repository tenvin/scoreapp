package com.twg.service;

import com.twg.entity.*;

import com.twg.repository.ScoreRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tenvin on 2017/7/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml","classpath:spring/spring-mvc.xml"})
@WebAppConfiguration
@Transactional
public class ScoreServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ScoreService scoreService;

    @Test
    public void testFindAll() {
        List<Score> scores = scoreService.findAll();
        logger.info("scores={}", scores);
    }

    @Test
    public void testSave() {
        Score score = new Score(new Xueqi("第一学期"),
                new Zhuanye("计算机"),
                new Banji("1班"),
                new Student("张三"),
                new Kemu("数学"),
                80);
        Score score1 = new Score(new Xueqi("第一学期"),
                new Zhuanye("计算机"),
                new Banji("1班"),
                new Student("张三"),
                new Kemu("数学"),
                80);
        List<Score> scores = new ArrayList<Score>();
        scores.add(score);
        scores.add(score1);
        scoreService.save(scores);
    }

    @Test
    public void testGetOne() {
        Score score = scoreService.get(8);
        System.out.println("score:" + score);
    }

    @Test
    public void testQueryByXsName(){
        List<Score> scores = scoreService.queryByXsName("邱万帅");
        logger.info("scores={}", scores);
    }

    @Test
    public void testQueryByKmName(){
        List<Score> scores = scoreService.queryByKmName("数学");
        logger.info("scores={}", scores);
    }

}
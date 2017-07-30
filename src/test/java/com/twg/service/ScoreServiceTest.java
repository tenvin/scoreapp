package com.twg.service;

import com.twg.entity.Score;
import com.twg.repository.ScoreRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tenvin on 2017/7/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class ScoreServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ScoreService scoreService;

    @Test
    public void testFindAll(){
        List<Score> scores = scoreService.findAll();
        logger.info("scores={}",scores);
    }

}
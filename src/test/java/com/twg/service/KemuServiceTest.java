package com.twg.service;

import com.twg.entity.Kemu;
import com.twg.repository.KemuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by tenvin on 2017/7/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class KemuServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    KemuRepository kemuRepository;

    @Test
    public void testFindOne(){
        System.out.println("kemu="+kemuRepository.getOne(1));
    }
}
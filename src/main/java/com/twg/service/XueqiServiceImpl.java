package com.twg.service;

import com.twg.entity.Xueqi;
import com.twg.repository.XueqiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tenvin on 2017/7/28.
 */
@Service
public class XueqiServiceImpl implements XueqiService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    XueqiRepository xueqiRepository;

    public Xueqi get(Integer aLong) {
        return null;
    }

    public Xueqi save(Xueqi xueqi) {
        return null;
    }

    public List<Xueqi> save(List<Xueqi> list) {
        return null;
    }

    public void delete(Integer id) {

    }

    public List<Xueqi> findAll() {
        return xueqiRepository.findAll();
    }
}

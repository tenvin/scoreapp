package com.twg.service;

import com.twg.entity.Kemu;
import com.twg.entity.Score;
import com.twg.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created by tenvin on 2017/7/26.
 */

public interface ScoreService extends BaseService<Score,Integer>{
    public List<Score> queryByXsName(String name);

    public List<Score> queryByBjName(String name);

    public List<Score> queryByZyName(String name);

    public List<Score> queryByKmName(String name);
}

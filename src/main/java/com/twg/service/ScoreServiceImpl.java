package com.twg.service;

import com.twg.entity.Score;
import com.twg.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tenvin on 2017/7/30.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public Score get(Long aLong) {
        return null;
    }

    public Score save(Score score) {
        return null;
    }

    public void delete(Long aLong) {

    }

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }
}

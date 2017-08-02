package com.twg.service;

import com.twg.entity.Score;
import com.twg.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tenvin on 2017/7/30.
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public Score get(Integer id) {
        return scoreRepository.getOne(id);
    }

    public Score save(Score score) {
        return scoreRepository.save(score);
    }

    public List<Score> save(List<Score> scores) {
        return scoreRepository.save(scores);
    }

    public void delete(Integer id) {
        scoreRepository.delete(id);
    }

    public List<Score> findAll() {
        return scoreRepository.findAll();
    }


    public List<Score> queryByXsName(String name) {
        return scoreRepository.queryByXsName(name);
    }

    public List<Score> queryByBjName(String name) {
        return scoreRepository.queryByBjName(name);
    }

    public List<Score> queryByZyName(String name) {
        return scoreRepository.queryByZyName(name);
    }

    public List<Score> queryByKmName(String name) {
        return scoreRepository.queryByKmName(name);
    }


}

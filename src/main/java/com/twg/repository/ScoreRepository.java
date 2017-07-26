package com.twg.repository;

import com.twg.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tenvin on 2017/7/26.
 */
public interface ScoreRepository extends JpaRepository<Score,Long> {
}

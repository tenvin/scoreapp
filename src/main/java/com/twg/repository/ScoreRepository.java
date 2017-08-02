package com.twg.repository;

import com.twg.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by tenvin on 2017/7/26.
 */
public interface ScoreRepository extends JpaRepository<Score,Integer> {
    @Query("select o from Score o where o.student.xsName=?1")
    public List<Score> queryByXsName(String name);

    @Query("select o from Score o where o.banji.bjName=?1")
    public List<Score> queryByBjName(String name);

    @Query("select o from Score o where o.zhuanye.zyName=?1")
    public List<Score> queryByZyName(String name);

    @Query("select o from Score o where o.kemu.kmName=?1")
    public List<Score> queryByKmName(String name);
}

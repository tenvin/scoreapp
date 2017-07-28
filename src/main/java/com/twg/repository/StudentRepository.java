package com.twg.repository;

import com.twg.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by tenvin on 2017/7/26.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByXsName(String name);
}

package com.twg.service;

import com.twg.entity.Student;
import com.twg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tenvin on 2017/7/25.
 */

public interface StudentService extends BaseService<Student,Integer>{

    public Student findByName(String name);

}

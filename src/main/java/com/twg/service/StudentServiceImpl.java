package com.twg.service;

import com.twg.entity.Student;
import com.twg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tenvin on 2017/7/26.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student findByName(String name) {
        return studentRepository.findByXsName(name);
    }

    public Student get(Integer integer) {
        return null;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> save(List<Student> list) {
        return null;
    }

    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    public List<Student> findAll() {
        return null;
    }
}

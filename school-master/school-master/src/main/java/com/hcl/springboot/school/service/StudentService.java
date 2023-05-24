package com.hcl.springboot.school.service;

import com.hcl.springboot.school.entity.School;
import com.hcl.springboot.school.entity.Student;

import java.util.List;

public interface StudentService
{
    public List<Student> findAll();

    public Student findById(int theId);

    public void save(Student student);

    public void deleteById(int theId);
}

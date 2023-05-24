package com.hcl.springboot.school.service;

import com.hcl.springboot.school.entity.Student;
import com.hcl.springboot.school.entity.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> findAll();

    public Teacher findById(int theId);

    public void save(Teacher teacher);

    public void deleteById(int theId);
}

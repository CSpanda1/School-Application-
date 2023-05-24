package com.hcl.springboot.school.repository;

import com.hcl.springboot.school.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>
{
    public List<Student> findAllBySchoolAssociated(int schoolID);
    public List<Student> findAllByTeacherID(int teacherID);
    public void deleteById(int theId);
}


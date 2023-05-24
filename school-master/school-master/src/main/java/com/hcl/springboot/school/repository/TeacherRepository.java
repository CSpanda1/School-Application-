package com.hcl.springboot.school.repository;

import com.hcl.springboot.school.entity.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, Integer>
{
    public void deleteById(int theId);
}

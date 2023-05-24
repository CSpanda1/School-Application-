package com.hcl.springboot.school.repository;

import com.hcl.springboot.school.entity.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends MongoRepository<School, Integer>
{
    public void deleteById(int theId);
}

package com.hcl.springboot.school.service;

import com.hcl.springboot.school.entity.School;

import java.util.List;

public interface SchoolService
{
    public List<School> findAll();

    public School findById(int theId);

    public void save(School school);

    public void deleteById(int theId);


}

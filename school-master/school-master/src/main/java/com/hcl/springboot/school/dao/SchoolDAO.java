package com.hcl.springboot.school.dao;

import com.hcl.springboot.school.entity.School;

import java.util.List;

public interface SchoolDAO
{
    public List<School> findAll();

    public School findById(int theId);

    public void save(School theSchool);

    public void deleteById(int theId);

}

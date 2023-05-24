package com.hcl.springboot.school.resolver;

import com.hcl.springboot.school.entity.School;
import com.hcl.springboot.school.repository.SchoolRepository;
import com.hcl.springboot.school.repository.StudentRepository;
import com.hcl.springboot.school.repository.TeacherRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MutationResolver implements GraphQLMutationResolver
{
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public MutationResolver(SchoolRepository schoolRepository, StudentRepository studentRepository, TeacherRepository teacherRepository)
    {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public School schoolByID(Integer schoolID,String schoolName, Integer schoolRegisteredNumber) {
        School school = new School();
        school.setSchoolID(schoolID);
        school.setSchoolName(schoolName);
        school.setSchoolRegisteredNumber(schoolRegisteredNumber);

        schoolRepository.save(school);

        return school;
    }

    public boolean deleteSchool(int id) {
        schoolRepository.deleteById(id);
        return true;
    }



}

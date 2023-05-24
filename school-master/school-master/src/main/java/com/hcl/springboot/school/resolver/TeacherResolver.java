package com.hcl.springboot.school.resolver;

import com.hcl.springboot.school.entity.School;
import com.hcl.springboot.school.entity.Student;
import com.hcl.springboot.school.entity.Teacher;
import com.hcl.springboot.school.repository.SchoolRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TeacherResolver implements GraphQLResolver<Teacher>
{
    @Autowired
    private SchoolRepository schoolRepository;

    public TeacherResolver(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    public Optional<School> getTeacher(Teacher teacher) {
        return schoolRepository.findById(teacher.getTeacherID());
    }
}

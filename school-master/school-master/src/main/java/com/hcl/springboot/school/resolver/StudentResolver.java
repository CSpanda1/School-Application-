package com.hcl.springboot.school.resolver;

import com.hcl.springboot.school.entity.School;
import com.hcl.springboot.school.entity.Student;
import com.hcl.springboot.school.entity.Teacher;
import com.hcl.springboot.school.repository.SchoolRepository;
import com.hcl.springboot.school.repository.StudentRepository;
import com.hcl.springboot.school.repository.TeacherRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentResolver implements GraphQLResolver<Student>
{
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public StudentResolver(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public Optional<School> getSchool(Student student) {
        return schoolRepository.findById(student.getStudentID());
    }

    public Optional<Teacher> getTeacher(Student student) {
        return teacherRepository.findById(student.getTeacherID());
    }
}

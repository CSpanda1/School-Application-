package com.hcl.springboot.school.resolver;


import com.hcl.springboot.school.entity.School;
import com.hcl.springboot.school.entity.Student;
import com.hcl.springboot.school.entity.Teacher;
import com.hcl.springboot.school.repository.SchoolRepository;
import com.hcl.springboot.school.repository.StudentRepository;
import com.hcl.springboot.school.repository.TeacherRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Query implements GraphQLQueryResolver
{

    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public Query(SchoolRepository schoolRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @QueryMapping
    public Optional<Student> studentsById(int id)
    {
        return studentRepository.findById(id);
    }


    @BatchMapping
    Map<School,Student> studentSchool (List<School> schools)
    {
        return schools.stream().collect(Collectors.toMap(school -> school,school -> new Student()));
    }

    @SubscriptionMapping
    public Flux<List<Student>> student()
    {
        return Flux.fromStream(Stream.generate(()-> studentRepository.findAll())).delayElements(Duration.ofSeconds(15));
    }


public List<Student> studentsBySchool(int id)
{
    return studentRepository.findAllBySchoolAssociated(id);
}

    public List<Student> studentsByTeacher(int id)
    {
        return studentRepository.findAllByTeacherID(id);
    }


    public Iterable<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public long countSchools() {
        return schoolRepository.count();
    }

    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }
    public long countStudents() {
        return studentRepository.count();
    }

    public Iterable<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public long countTeachers() {
        return teacherRepository.count();
    }
}

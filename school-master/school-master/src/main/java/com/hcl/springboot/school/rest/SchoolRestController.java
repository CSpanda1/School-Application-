package com.hcl.springboot.school.rest;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.hcl.springboot.school.entity.School;
import com.hcl.springboot.school.entity.Student;
import com.hcl.springboot.school.entity.Teacher;
import com.hcl.springboot.school.repository.SchoolRepository;
import com.hcl.springboot.school.repository.StudentRepository;
import com.hcl.springboot.school.repository.TeacherRepository;
import com.hcl.springboot.school.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SchoolRestController
{
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/School")
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @PostMapping("/School")
    public School createSchool(@Valid @RequestBody School school) {
        school.setSchoolID((int) sequenceGeneratorService.generateSequence(School.SEQUENCE_NAME));
        return schoolRepository.save(school);
    }

    @PutMapping("/School")
    public School updateSchool(@RequestBody School theSchool)
    {
        schoolRepository.save(theSchool);
        return theSchool;
    }

    @DeleteMapping("/School/{schoolID}")
    public String deleteSchool(@PathVariable int schoolID)
    {
        Optional<School> tempSchool = schoolRepository.findById(schoolID);

        //throw exception if null

        if (tempSchool== null)
        {
            throw new RuntimeException("School id not found - " + schoolID);
        }

        schoolRepository.deleteById(schoolID);

        return "Deleted customer id - " + schoolID;
    }



    @GetMapping("/Student")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/Student")
    public Student createStudent(@Valid @RequestBody Student student) {
        student.setStudentID((int) sequenceGeneratorService.generateSequence(School.SEQUENCE_NAME));
        return studentRepository.save(student);
    }

    @PutMapping("/Student")
    public Student updateStudent(@RequestBody Student theStudent)
    {
        studentRepository.save(theStudent);
        return theStudent;
    }

    @DeleteMapping("/Student/{studentID}")
    public String deleteStudent(@PathVariable int studentID)
    {
        Optional<Student> tempStudent = studentRepository.findById(studentID);

        //throw exception if null

        if (tempStudent== null)
        {
            throw new RuntimeException("Student id not found - " + studentID);
        }

        studentRepository.deleteById(studentID);

        return "Deleted student id - " + studentID;
    }


    @GetMapping("/Teacher")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @PostMapping("/Teacher")
    public Teacher createTeacher(@Valid @RequestBody Teacher teacher) {
        teacher.setTeacherID((int) sequenceGeneratorService.generateSequence(School.SEQUENCE_NAME));
        return teacherRepository.save(teacher);
    }

    @PutMapping("/Teacher")
    public Teacher updateTeacher(@RequestBody Teacher theTeacher)
    {
        teacherRepository.save(theTeacher);
        return theTeacher;
    }


    @DeleteMapping("/Teacher/{teacherID}")
    public String deleteTeacher(@PathVariable int teacherID)
    {
        Optional<Teacher> tempTeacher = teacherRepository.findById(teacherID);

        //throw exception if null

        if (tempTeacher== null)
        {
            throw new RuntimeException("Teacher id not found - " + teacherID);
        }

        teacherRepository.deleteById(teacherID);

        return "Deleted Teacher id - " + teacherID;
    }







}

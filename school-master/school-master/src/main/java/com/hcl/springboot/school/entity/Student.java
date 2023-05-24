package com.hcl.springboot.school.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Student")
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private int studentId;

    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String studentName;

    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String studentClass;

    private int teacherID;


    private int schoolAssociated;

    public Student(){

    }

    public Student( String studentName, String studentClass, int teacherID, int schoolAssociated)
    {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.teacherID = teacherID;
        this.schoolAssociated = schoolAssociated;
    }



    public int getStudentID() {
        return studentId;
    }

    public void setStudentID(int studentID) {
        this.studentId = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getSchoolAssociated() {
        return schoolAssociated;
    }

    public void setSchoolAssociated(int schoolAssociated) {
        this.schoolAssociated = schoolAssociated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", teacherID=" + teacherID +
                ", schoolAssociated=" + schoolAssociated +
                '}';
    }


}


package com.hcl.springboot.school.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Teacher")
public class Teacher
{

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private int teacherID;

    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String teacherName;


    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String educationQualification;


    private int schoolAssociated;

    public Teacher()
    {

    }

    public Teacher( String teacherName, String educationQualification, int schoolAssociated) {
        this.teacherName = teacherName;
        this.educationQualification = educationQualification;
        this.schoolAssociated = schoolAssociated;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getEducationQualification() {
        return educationQualification;
    }

    public void setEducationQualification(String educationQualification) {
        this.educationQualification = educationQualification;
    }

    public int getSchoolAssociated() {
        return schoolAssociated;
    }

    public void setSchoolAssociated(int schoolAssociated) {
        this.schoolAssociated = schoolAssociated;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherID +
                ", teacherName='" + teacherName + '\'' +
                ", educationQualification='" + educationQualification + '\'' +
                ", schoolAssociated=" + schoolAssociated +
                '}';
    }
}

package com.hcl.springboot.school.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Document(collection = "School")
public class School
{

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private int schoolID;

    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String schoolName;
    private int schoolRegisteredNumber;

    public School()
    {

    }

    public School(@NotBlank @Size(max = 100) String schoolName, int schoolRegisteredNumber) {
        this.schoolName = schoolName;
        this.schoolRegisteredNumber = schoolRegisteredNumber;
    }


    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolRegisteredNumber() {
        return schoolRegisteredNumber;
    }

    public void setSchoolRegisteredNumber(int schoolRegisteredNumber) {
        this.schoolRegisteredNumber = schoolRegisteredNumber;
    }

    @Override
    public String toString()
    {
        return "School{" +
                "schoolId=" + schoolID +
                ", schoolName='" + schoolName + '\'' +
                ", schoolRegisteredNumber=" + schoolRegisteredNumber +
                '}';
    }
}
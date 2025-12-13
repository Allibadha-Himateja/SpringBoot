package com.iss.springboot.Services;

import com.iss.springboot.Models.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    List<Student> getStudents();
}

package com.iss.springboot.Services;

import com.iss.springboot.Models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    List<Student> students;
    public StudentService() {
        students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }
}

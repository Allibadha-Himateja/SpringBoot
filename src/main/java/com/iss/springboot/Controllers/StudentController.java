package com.iss.springboot.Controllers;

import com.iss.springboot.Models.Student;
import com.iss.springboot.Services.IStudentService;
import com.iss.springboot.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

//    @Autowired
    private IStudentService studentService;
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String newStudent() {
        return "student/newstudent";
    }

    @PostMapping
    public String newStudent(Student student) {
        studentService.addStudent(student);
        return "student/newstudent";
        // here we have to make a important observation
        // which is we are redirecting to the newstudent page again and again after submitting the student details
        // so when calling the list we are getting all the save student why??

        // i mean to say even after resending the requests
        // and not storing the data in the session we can able to store all the students howw?
        // THIS IS BECAUSE WE ARE CREATING THIS SERVICE CLASS ONLY ONCE WHICH IS WE ARE CREATING THE COLLECTION ONLY ONCE
        // WE ARE USING THE SAME COLLECTION FOR EVERY REQUEST
        // BEAN SCOPE IS SINGLETON
    }

    @GetMapping("/list")
    public String getStudents(Model model)
    {
        model.addAttribute("studentList", studentService.getStudents());
        return "student/studentsList";
    }
}

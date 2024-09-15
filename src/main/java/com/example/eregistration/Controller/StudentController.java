package com.example.eregistration.Controller;

import com.example.eregistration.Model.Student;
import com.example.eregistration.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/eregistrar")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list";
    }

    @GetMapping("/students/new")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/students")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentService.createStudent(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        student.setStudentId(id);
        studentService.createStudent(student);
        return "redirect:/eregistrar/students";
    }
}

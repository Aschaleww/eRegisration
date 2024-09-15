package com.example.eregistration.Service;

import com.example.eregistration.Model.Student;
import com.example.eregistration.Respository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }
    public Student getStudentById(Long id){
        return  studentRepository.findById(id).orElse(null);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    public List<Student> searchStudents(String name){
        return  studentRepository.findByFirstName(name);
    }
//    public Student updateStudent(Long id){
//        return studentRepository.u
//    }
}

package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.studentModel;
import com.example.springbootbackend.response.MessageResponse;
import com.example.springbootbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/student")

public class studentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/getstudents")
    public List<studentModel> getAllStudents(){
        return studentService.getStudent();
    }


    @PostMapping(value = "/addstudent")
    public MessageResponse addStudent(@RequestBody studentModel student){
        return studentService.addStudentDetails(student);
    }


    @PutMapping("/update/{id}")
    public MessageResponse updateStudent(@RequestBody studentModel student , @PathVariable Integer id){
        return studentService.updateStudentDetails(student,id);
    }


    @GetMapping("/getstudent/{id}")
    public Optional<studentModel> getStudent(@PathVariable Integer id){
        return studentService.getStudentData(id);
    }

    @DeleteMapping("/delete/{id}")
    public MessageResponse deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudentDetails(id);
    }




}

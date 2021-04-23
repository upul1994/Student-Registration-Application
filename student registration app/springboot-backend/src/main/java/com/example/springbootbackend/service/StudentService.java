package com.example.springbootbackend.service;

import com.example.springbootbackend.model.studentModel;
import com.example.springbootbackend.response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<studentModel> getStudent();

    MessageResponse addStudentDetails(studentModel student);

    Optional<studentModel> getStudentData(Integer id);

    MessageResponse deleteStudentDetails(Integer id);

    MessageResponse updateStudentDetails(studentModel student, Integer id);
}

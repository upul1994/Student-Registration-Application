package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.model.studentModel;
import com.example.springbootbackend.repository.StudentRepository;
import com.example.springbootbackend.response.MessageResponse;
import com.example.springbootbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService  {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<studentModel> getStudent() {
        return studentRepository.findAll();
    }


    @Override
    public MessageResponse addStudentDetails(studentModel student) {
        studentRepository.save(student);
        return new MessageResponse("student data saved successfully");
    }

    @Override
    public MessageResponse updateStudentDetails(studentModel student , Integer id) {
        MessageResponse msg =null;
        Optional<studentModel> studentDetails = studentRepository.findById(id);
        if (studentDetails.isPresent()) {
            studentModel mystudent = studentDetails.get();
            mystudent.setFirstName(student.getFirstName());
            mystudent.setLastName(student.getLastName());
            mystudent.setAge(student.getAge());
            mystudent.setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(mystudent);
            msg= new MessageResponse("student data updated successfully");
        }else{
            msg=new MessageResponse("This id is not exist");
        }
        return msg;
    }

    @Override
    public Optional<studentModel> getStudentData(Integer id) {
        return studentRepository.findById(id);

    }

    @Override
    public MessageResponse deleteStudentDetails(Integer id) {
        MessageResponse msg =null;
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            msg= new MessageResponse("student data deleted successfully");
        }else{
            msg= new MessageResponse("this id is not exist");
        }
        return msg;
    }


}





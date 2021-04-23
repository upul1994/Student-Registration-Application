package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.studentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<studentModel,Integer> {

}

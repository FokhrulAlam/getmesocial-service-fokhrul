package com.fokhrul.SchoolManagementSystem.service;

import com.fokhrul.SchoolManagementSystem.model.Students;
import com.fokhrul.SchoolManagementSystem.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public Students getStudents(String studentId){
        return schoolRepository.getStudents(studentId);
    }

    public void setStudents(Students students){
        schoolRepository.setStudents(students);
    }


}

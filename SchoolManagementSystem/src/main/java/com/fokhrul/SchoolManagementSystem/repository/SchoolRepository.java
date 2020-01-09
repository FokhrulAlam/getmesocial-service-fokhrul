package com.fokhrul.SchoolManagementSystem.repository;

import com.fokhrul.SchoolManagementSystem.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SchoolRepository {
    @Autowired
    private Students students;

    private Map<String, Students> studentsMap;

    public Students getStudents(String studentId) {
        return studentsMap.get(studentId);
    }

    public void setStudents(Students students) {
        if (studentsMap==null) studentsMap = new HashMap<>();
        this.studentsMap.put(students.getStudentId(), students);
    }
}

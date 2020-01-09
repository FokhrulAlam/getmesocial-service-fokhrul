package com.fokhrul.SchoolManagementSystem.service;

import com.fokhrul.SchoolManagementSystem.model.schoolBody.Student;
import com.fokhrul.SchoolManagementSystem.model.schoolBody.Teacher;
import com.fokhrul.SchoolManagementSystem.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    /**
     * Getter and setter for students
     */
    public Student getStudents(String studentId){
        return schoolRepository.getStudents(studentId);
    }

    public void setStudents(Student students){
        schoolRepository.setStudents(students);
    }

    public void updateStudent(String studentId, double studentFeesPaid){
        schoolRepository.updateStudents(studentId, studentFeesPaid);
    }
    public void deleteteStudent(String studentId){
        schoolRepository.deleteStudents(studentId);
    }

    /**
     * Getter and Setter for teachers
     */
    public Teacher getTeachers(String teacherId){
        return schoolRepository.getTeachers(teacherId);
    }

    public void setTeacher(Teacher teachers){
        schoolRepository.setTeachers(teachers);
    }

    public void updateTeacher(String teacherId, double teacherSalaryPaid){
        schoolRepository.updateTeachers(teacherId, teacherSalaryPaid);
    }
    public void deleteTeacher(String teacherId){
        schoolRepository.deleteTeacher(teacherId);
    }

}

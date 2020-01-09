package com.fokhrul.SchoolManagementSystem.repository;

import com.fokhrul.SchoolManagementSystem.model.schoolBody.Student;
import com.fokhrul.SchoolManagementSystem.model.schoolBody.Teacher;
import jdk.vm.ci.code.site.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SchoolRepository {
    @Autowired
    private Student students;
    @Autowired
    private Teacher teachers;

    private Map<String, Student> studentsMap;
    private Map<String, Teacher> teachersMap;

    /**
     * Getter and setter methods for students
     */
    public Student getStudents(String studentId) {
        if (studentsMap.containsKey(studentId) == false){
            return null;
        }
        return studentsMap.get(studentId);
    }
    public void setStudents(Student students) {
        if (studentsMap==null) studentsMap = new HashMap<>();
        this.studentsMap.put(students.getStudentId(), students);
    }
    public void updateStudents(String studentId, double studentFeesPaid){
        Student student = studentsMap.get(studentId);
        student.updateStudentFeesPaid(studentFeesPaid);
    }
    public void deleteStudents(String studentId){
        studentsMap.remove(studentId);
    }

    /**
     * getter and setter methods for teachers
     */
    public Teacher getTeachers(String teacherId) {
        return teachersMap.get(teacherId);
    }
    public void setTeachers(Teacher teachers) {
        if (teachersMap==null) teachersMap = new HashMap<>();
        this.teachersMap.put(teachers.getTeacherId(), teachers);
    }
    public void updateTeachers(String teacherId, double teacherSalaryPaid){
        Teacher teacher = teachersMap.get(teacherId);
        teacher.updateTeacherSalaryPaid(teacherSalaryPaid);
    }
    public void deleteTeacher(String teacherId){
        teachersMap.remove(teacherId);
    }
}

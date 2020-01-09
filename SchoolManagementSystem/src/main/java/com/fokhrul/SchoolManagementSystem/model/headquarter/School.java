package com.fokhrul.SchoolManagementSystem.model.headquarter;

import com.fokhrul.SchoolManagementSystem.model.schoolBody.Student;
import com.fokhrul.SchoolManagementSystem.model.schoolBody.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
    @Autowired
    private Student students;
    @Autowired
    private Teacher teachers;

    /**
     * Default constructor
     */
    public School(){

    }

    /**
     * Parameterized constructor
     * @param students
     * @param teachers
     */
    public School(Student students, Teacher teachers) {
        this.students = students;
        this.teachers = teachers;
    }

    /**
     * Getter and Setter methods
     */
    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }
}

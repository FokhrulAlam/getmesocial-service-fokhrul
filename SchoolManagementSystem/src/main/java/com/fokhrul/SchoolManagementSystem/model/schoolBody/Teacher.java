package com.fokhrul.SchoolManagementSystem.model.schoolBody;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private String teacherId;
    private String teacherName;
    private String teacherPosition;
    private double teacherYearlySalary;
    private double teacherSalaryPaid;

    /**
     * Default constructor
     */
    public Teacher(){
    }

    /**
     * Parameterized constructor
     * @param teacherId
     * @param teacherName
     * @param teacherPosition
     * @param teacherYearlySalary
     */
    public Teacher(String teacherId, String teacherName, String teacherPosition,
                   double teacherYearlySalary) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPosition = teacherPosition;
        this.teacherYearlySalary = teacherYearlySalary;
        this.teacherSalaryPaid = 0;
    }

    /**
     * Getter and setter methods
     */
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }

    public double getTeacherYearlySalary() {
        return teacherYearlySalary;
    }

    public void updateTeacherYearlySalary(double teacherYearlySalary) {
        this.teacherYearlySalary = teacherYearlySalary;
    }

    public double getTeacherSalaryPaid() {
        return teacherSalaryPaid;
    }

    public void updateTeacherSalaryPaid(double teacherSalaryPaid) {
        this.teacherSalaryPaid = teacherSalaryPaid;
    }
}

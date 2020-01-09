package com.fokhrul.SchoolManagementSystem.model;

import org.springframework.stereotype.Component;

@Component
public class Students {
    /**
     * Attributes
     */
    private String studentId;
    private String studentName;
    private String studentGrade;
    private double studentYearlyFees;
    private double studentFeesPaid;

    public Students(){

    }
    /**
     * Constructor
     * @param studentId
     * @param studentName
     * @param studentGrade
     * @param studentYearlyFees
     * @param studentFeesPaid
     */
    public Students(String studentId, String studentName, String studentGrade,
                    double studentYearlyFees, double studentFeesPaid) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.studentYearlyFees = studentYearlyFees;
        this.studentFeesPaid = studentFeesPaid;
    }

    /**
     * Getter and setter methods.
     * @return
     */
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public double getStudentYearlyFees() {
        return studentYearlyFees;
    }

    public void setStudentYearlyFees(double studentYearlyFees) {
        this.studentYearlyFees = studentYearlyFees;
    }

    public double getStudentFeesPaid() {
        return studentFeesPaid;
    }

    public void setStudentFeesPaid(double studentFeesPaid) {
        this.studentFeesPaid = studentFeesPaid;
    }
}

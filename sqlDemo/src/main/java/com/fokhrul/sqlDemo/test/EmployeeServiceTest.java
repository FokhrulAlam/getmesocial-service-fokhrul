//package com.fokhrul.sqlDemo.test;
//
//import com.fokhrul.sqlDemo.entity.EmployeeEntity;
//import com.fokhrul.sqlDemo.service.EmployeeService;
//
//public class EmployeeServiceTest {
//
//    @org.junit.jupiter.api.Test
//    public void testUserCreation() throws Throwable{
//
//        EmployeeEntity employeeEntity = new EmployeeEntity((long) 4,"Fokhrul","Alam","fokhrul@gmail.com");
//        EmployeeService employeeService = new EmployeeService();
//
//        EmployeeEntity employee = employeeService.createOrUpdateEmployee(employeeEntity);
//
//        assert(employeeEntity.getEmail().equals(employee.getEmail()));
//
//    }
//}

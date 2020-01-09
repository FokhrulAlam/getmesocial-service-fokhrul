package com.fokhrul.SchoolManagementSystem.resource;


import com.fokhrul.SchoolManagementSystem.model.Students;
import com.fokhrul.SchoolManagementSystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/main")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/{studentId}")
    public Students getStudent(@PathVariable String studentId){

        return schoolService.getStudents(studentId);
    }

    @PostMapping (value = "/add")
    public Students addStudent(@RequestBody Students students){

        schoolService.setStudents(students);

        return schoolService.getStudents(students.getStudentId());

    }
}

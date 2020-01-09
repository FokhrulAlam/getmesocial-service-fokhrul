package com.fokhrul.SchoolManagementSystem.resource;


import com.fokhrul.SchoolManagementSystem.model.schoolBody.Student;
import com.fokhrul.SchoolManagementSystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable String studentId){
        return schoolService.getStudents(studentId);
    }

    @PostMapping (value = "/addStudent")
    public Student addStudent(@RequestBody Student students){
        schoolService.setStudents(students);
        return schoolService.getStudents(students.getStudentId());
    }

    @PutMapping(path = "/{studentId}")
    public Student updateStudent(@PathVariable String studentId, @RequestBody Student students){
        schoolService.updateStudent(studentId, students.getStudentFeesPaid());
        return schoolService.getStudents(studentId);
    }

    @DeleteMapping( path = "/{studentId}")
    public void deleteStudent(@PathVariable String studentId){
        schoolService.deleteteStudent(studentId);
    }
}

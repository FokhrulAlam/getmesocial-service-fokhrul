package com.fokhrul.SchoolManagementSystem.resource;

import com.fokhrul.SchoolManagementSystem.model.schoolBody.Teacher;
import com.fokhrul.SchoolManagementSystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping(path = "/{teacherId}")
    public Teacher getTeacher(@PathVariable String teacherId){
        return schoolService.getTeachers(teacherId);
    }

    @PostMapping(value = "/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teachers){
        schoolService.setTeacher(teachers);
        return schoolService.getTeachers(teachers.getTeacherId());
    }

    @PutMapping(path = "/{teacherId}")
    public Teacher updateTeacher(@PathVariable String teacherId, @RequestBody Teacher teachers){
        schoolService.updateTeacher(teacherId, teachers.getTeacherSalaryPaid());
        return schoolService.getTeachers(teacherId);
    }

    @DeleteMapping( path = "/{teacherId}")
    public void deleteTeacher(@PathVariable String teacherId){
        schoolService.deleteTeacher(teacherId);
    }
}

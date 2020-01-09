package com.fokhrul.SchoolManagementSystem.model;

import org.springframework.stereotype.Component;

@Component
public class Teachers {
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}

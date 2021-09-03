package com.mycourse.backend.controllers;

import com.mycourse.backend.models.dto.CourseDTO;
import com.mycourse.backend.models.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/cursos")
    public List<CourseDTO> findAllCourse(){
        return courseService.findAllCourse();
    }

    @PostMapping("/salvar")
    public CourseDTO saveCourse(CourseDTO course){
        return courseService.saveCourse(course);
    }

}

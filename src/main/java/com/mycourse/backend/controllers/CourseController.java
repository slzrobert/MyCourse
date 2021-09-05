package com.mycourse.backend.controllers;

import com.mycourse.backend.models.dtos.CourseDTO;
import com.mycourse.backend.models.services.CourseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(path = "")
    public List<CourseDTO> findAllCourse(){
        return courseService.findAllCourse();
    }

    @PutMapping(path = "/{id}")
    public CourseDTO editCourse(@RequestBody CourseDTO course, @PathVariable Long id){
        return courseService.editCourse(course, id);
    }

    @PostMapping("/salvar")
    public CourseDTO saveCourse(@RequestBody CourseDTO course){
        return courseService.saveCourse(course);
    }

}

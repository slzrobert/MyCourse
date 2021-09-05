package com.mycourse.backend.models.services;

import com.mycourse.backend.models.dtos.CourseDTO;
import com.mycourse.backend.models.entities.Course;
import com.mycourse.backend.models.repositories.CourseRepository;
import com.mycourse.backend.utils.Mapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> findAllCourse(){
        return mapper.mapCollection(this.courseRepository.findAll(), CourseDTO.class);
    }

    public CourseDTO editCourse(CourseDTO course, Long id){

        Optional<Course> curso = courseRepository.findById(id)
                .map(c -> {
                    c.setName(course.getName());
                    return courseRepository.save(c);
                });

        return mapper.generalMapper(
                curso.get(),
                CourseDTO.class
        );

    }

    @Transactional
    public CourseDTO saveCourse(CourseDTO course){
        return mapper.generalMapper(
                this.courseRepository.save(
                        mapper.generalMapper(course, Course.class)
                ),
                CourseDTO.class
        );
    }
}

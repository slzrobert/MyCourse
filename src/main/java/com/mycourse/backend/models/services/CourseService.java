package com.mycourse.backend.models.services;

import com.mycourse.backend.models.dto.CourseDTO;
import com.mycourse.backend.models.entities.Course;
import com.mycourse.backend.models.repositories.CourseRepository;
import com.mycourse.backend.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseDTO> findAllCourse(){
        return mapper.mapCollection(this.courseRepository.findAll(), CourseDTO.class);
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

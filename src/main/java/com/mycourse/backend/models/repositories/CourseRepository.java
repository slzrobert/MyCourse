package com.mycourse.backend.models.repositories;

import com.mycourse.backend.models.dtos.CourseDTO;
import com.mycourse.backend.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Transactional(readOnly = true)
    @Query("select new com.mycourse.backend.models.dtos.CourseDTO(course.id, course.name) "
            + "from Course course")
    List<CourseDTO> findAllCourse();
}
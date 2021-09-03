package com.mycourse.backend.models.repositories;

import com.mycourse.backend.models.dto.CourseDTO;
import com.mycourse.backend.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select new com.mycourse.backend.models.dto.CourseDTO(course.id, course.name) "
            + "from Course course")
    List<CourseDTO> findAllCourse();
}
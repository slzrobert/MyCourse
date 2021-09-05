package com.mycourse.backend.models.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO implements Serializable {
    private Long id;
    private String name;
}
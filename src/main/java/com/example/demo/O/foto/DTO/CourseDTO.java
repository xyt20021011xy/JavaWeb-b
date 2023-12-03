package com.example.demo.O.foto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String courseNo;
    private String courseName;
    private Integer credit;
    private Integer creditHour;
    private Integer courseType;
    private Integer experimentType;
    private String description;

}


package com.example.demo.Service;

import com.example.demo.O.foto.DTO.CourseDTO;
import com.example.demo.O.foto.DTO.ExperimentitemsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseSeivice {
    List<ExperimentitemsDTO> getCourse();

    List<CourseDTO> get();
}

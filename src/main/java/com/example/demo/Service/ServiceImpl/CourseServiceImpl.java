package com.example.demo.Service.ServiceImpl;

import com.example.demo.Mapper.CourseMapper;
import com.example.demo.O.foto.DTO.CourseDTO;
import com.example.demo.O.foto.DTO.ExperimentitemsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements com.example.demo.Service.CourseSeivice{

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List<ExperimentitemsDTO> getCourse() {
        System.out.println(courseMapper.getCourse());
        return courseMapper.getCourse();
    }

    @Override
    public List<CourseDTO> get() {
        System.out.println(courseMapper.getc());
        return courseMapper.getc();
    }
}

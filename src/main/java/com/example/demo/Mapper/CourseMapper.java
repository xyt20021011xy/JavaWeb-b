package com.example.demo.Mapper;


import com.example.demo.O.foto.DTO.CourseDTO;
import com.example.demo.O.foto.DTO.ExperimentitemsDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from experimentitems")
    List<ExperimentitemsDTO> getCourse();
    @Select("select * from courses")
    List<CourseDTO> getc();
}

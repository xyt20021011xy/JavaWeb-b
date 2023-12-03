package com.example.demo.Controller;

import com.example.demo.O.foto.DTO.CourseDTO;
import com.example.demo.O.foto.DTO.ExperimentitemsDTO;
import com.example.demo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private com.example.demo.Service.CourseSeivice courseSeivice;
    @GetMapping("/get1")
    public Result<List<ExperimentitemsDTO>> getCourse(){
        return Result.success(courseSeivice.getCourse());
    }
    @GetMapping("/get2")
    public Result<List<CourseDTO>> get(){
        return Result.success(courseSeivice.get());
    }
}

package com.example.demo.Controller;

import com.example.demo.O.foto.DTO.HandDTO;
import com.example.demo.O.foto.DTO.HomeworkDTO;
import com.example.demo.O.foto.VO.HandVO;
import com.example.demo.O.foto.entiry.Homework;
import com.example.demo.Result;
import com.example.demo.Service.HomeworkService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/homework")
public class HomeWorkController {
    @Autowired
    private HomeworkService homeworkService;

    /**
     * 获取所有作业
     * @return
     */
    @GetMapping
    public Result<List<Homework>> get(){
        List<Homework> homeworkList = homeworkService.get();
        return Result.success(homeworkList);
    }

    /**
     * 新增发布作业
     * @param homeworkDTO
     * @return
     */
    @PostMapping
    public Result insert(@RequestBody HomeworkDTO homeworkDTO){
        homeworkService.insert(homeworkDTO);
        return Result.success();
    }

    /**
     * 删除作业
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") int id){
        homeworkService.delete(id);
        return Result.success();
    }

    /**
     * 学生提交作业
     * @param handDTO
     * @return
     */
    @PostMapping("/student")
    public Result handWork(@RequestBody HandDTO handDTO){
        homeworkService.hand(handDTO);
        return Result.success();
    }
    /**
     * 教师查看学生提交的作业
     * @param homeid
     */
    @GetMapping("/student/{homeid}")
    public Result<List<HandVO>> getHand(@PathVariable("homeid") String homeid){
        List<HandVO> handVOList = homeworkService.getHand(homeid);
        return Result.success(handVOList);
    }
}

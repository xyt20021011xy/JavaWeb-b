package com.example.demo.Controller;

import com.example.demo.O.foto.VO.DailyAcVO;
import com.example.demo.O.foto.DTO.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class DataController {
    @Autowired
    private  com.example.demo.Service.DataService dataService;

    /**
     * 获取日活量
     */
    @GetMapping("/getdata")
    public List<DailyAcVO> getdata(){
        return dataService.getdata();
    }

    @PostMapping("/top")
    public void top(@RequestBody Name name){
        System.out.println(name.getName());
        dataService.top(name.getName());
    }
//    @GetMapping("/topday")
//    public List<String> topday(){
//        return dataService.topday();
//    }
//    @GetMapping("/topmonth")
//    public List<String> topmonth(){
//        return dataService.topmonth();
//    }

}

package com.example.demo.Controller;

import com.example.demo.O.PageResult;
import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.VO.UserVO;
import com.example.demo.O.foto.entiry.User;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class UserController {
    @Autowired
    private com.example.demo.Service.FormService formService;

    /**
     * 分页查询
     * @param userDTO
     * @return
     */
    @PostMapping
    public PageResult getForm(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        PageResult pageResult = formService.getForm(userDTO);
        System.out.println(pageResult);
        return  pageResult;
    }

    /**
     * 删除
     * @param username
     */
    @DeleteMapping
    public void delete(@RequestParam String username){
        System.out.println(username);
        formService.delete(username);
    }

    @PostMapping("/update")
    public String update(@RequestBody User user){
        System.out.println(user);
        return formService.update(user);
    }

    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        user.setTime(java.time.LocalDate.now());
        System.out.println(user);
        return formService.insert(user);
    }

    @GetMapping("/get")
    public List<DateVO> get(){
        return formService.get();
    }
}

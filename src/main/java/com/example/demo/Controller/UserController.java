package com.example.demo.Controller;

import com.example.demo.O.foto.entiry.PageResult;
import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.entiry.User;
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
     * 参数is:1为学生，0为老师
     */
    /**
     * 分页查询
     * @param userDTO
     * @return
     */
    @PostMapping("/{is}")
    public PageResult getForm(@RequestBody UserDTO userDTO,@PathVariable String is){
        System.out.println(is);
        PageResult pageResult = formService.getForm(userDTO,is);
        return  pageResult;
    }

    /**
     * 删除
     * @param username
     */
    @DeleteMapping("/{is}")
    public void delete(@RequestParam String username,@PathVariable String is){
        System.out.println(username);
        formService.delete(username,is);
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PostMapping("/update/{is}")
    public String update(@RequestBody User user,@PathVariable String is){
        return formService.update(user,is);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @PostMapping("/insert/{is}")
    public String insert(@RequestBody User user,@PathVariable String is){
        user.setTime(java.time.LocalDate.now());
        return formService.insert(user,is);
    }

    /**
     * 获取
     * @return
     */
    @GetMapping("/get/{is}")
    public List<DateVO> get(@PathVariable String is){
        return formService.get(is);
    }
}

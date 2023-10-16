package com.example.demo.Controller;

import com.example.demo.O.foto.entiry.Login;
import com.example.demo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginContorller {
    @Autowired
    private com.example.demo.Service.LoginService loginService;

    @PostMapping("/login")

    public Result<String> login(@RequestBody Login login){
        System.out.println(login);
        String token = loginService.login(login);
        if(token!=null&&!"fail".equals(token)){
            loginService.record(login.getUsername());

            return Result.success(token);
        }


        return Result.error("fail");
    }
//    @GetMapping("/test")
//    public Result test(){
//        return new Result(200,"success","tesdfsfsdfsft");
//    }
//    @PostMapping("/layout")
//    public Result layout(){
//        return new Result(200,"success","layout");
//    }
}

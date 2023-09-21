package com.example.demo.Controller;
import com.example.demo.Aspect.Tidi;
import com.example.demo.O.Login;
import com.example.demo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5173/")
public class LoginContorller {
    @Autowired
    private com.example.demo.Service.LoginService loginService;

    @PostMapping("/login")

    public Result login(@RequestBody Login login){
        System.out.println(login);
        String token = loginService.login(login);
        if(token!=null&&!"fail".equals(token)){
            loginService.record(login.getUsername());

            return new Result(200,"success",token);
        }


        return new Result(500,"fail","账号或密码错误");
    }
    @GetMapping("/test")
    @Tidi
    public Result test(){
        return new Result(200,"success","tesdfsfsdfsft");
    }
    @PostMapping("/layout")
    public Result layout(){
        return new Result(200,"success","layout");
    }
}

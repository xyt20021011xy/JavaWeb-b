package com.example.demo.Service.ServiceImpl;

import com.example.demo.O.foto.entiry.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LoginServiceImpl implements com.example.demo.Service.LoginService{
    @Autowired
    private com.example.demo.Mapper.LoginMapper loginMapper;

    @Override
    public String login(Login login) {
        String password=loginMapper.selectPassword(login.getUsername());
        log.info("password:{}",password);
        if(login.getPassword().equals(password)){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", login.getUsername());
            return com.example.demo.Util.JwtToken.createJWT(claims);
        }

        else
            return "fail";

    }

    @Override
    public void record(String username) {
        LocalDate localDate=LocalDate.now();
        /**
         * 人流量排名
         */
        if(loginMapper.recordget(username)==null){
            System.out.println(loginMapper.getname(username));
            loginMapper.recordinsert(username,1,loginMapper.getname(username),localDate);
        }

        else
            loginMapper.recordupdate(username,(int)loginMapper.recordget(username)+1,localDate);
        /**
         * 日活量排名
         */
        if(loginMapper.recorddaily(localDate)==null) {
            loginMapper.recordinsertDaily(localDate, 1);
        }
        else{
            loginMapper.recordupdateDaily(localDate,(int)loginMapper.recorddaily(localDate)+1);
        }
    }
}

package com.example.demo.Service;

import com.example.demo.O.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {


    String login(Login login);

    void record(String username);
}

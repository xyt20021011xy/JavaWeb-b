package com.example.demo.Service;

import com.example.demo.O.foto.entiry.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {


    String login(Login login);

    void record(String username);
}

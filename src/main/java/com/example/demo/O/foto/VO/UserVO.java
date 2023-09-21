package com.example.demo.O.foto.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserVO {
    private int id;
    private String name;
    private String sex;
    private String username;
    private String password;
    private String phone;
    private LocalDate time;

}

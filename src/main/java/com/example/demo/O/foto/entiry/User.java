package com.example.demo.O.foto.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String sex;
    private String username;
    private String password;
    private String phone;
    private LocalDate time;

}

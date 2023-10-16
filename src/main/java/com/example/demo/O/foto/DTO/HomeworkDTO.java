package com.example.demo.O.foto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkDTO {
    private String teacher;
    private String details;
    private LocalDate starttime;
    private LocalDate endtime;
    private String studentlist;

}

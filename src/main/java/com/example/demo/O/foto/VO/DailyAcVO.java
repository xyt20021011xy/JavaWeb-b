package com.example.demo.O.foto.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyAcVO {
    private LocalDate date;
    private int dailycount;



}

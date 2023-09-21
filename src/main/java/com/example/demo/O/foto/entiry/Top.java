package com.example.demo.O.foto.entiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Top {
    private String name;
    private int count;
    private LocalDate date;
}

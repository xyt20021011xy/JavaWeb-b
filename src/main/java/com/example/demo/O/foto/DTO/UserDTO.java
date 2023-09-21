package com.example.demo.O.foto.DTO;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDTO {
    private int page;
    private int pageSize;
    private String name;
    private String username;

}

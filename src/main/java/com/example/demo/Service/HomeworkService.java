package com.example.demo.Service;

import com.example.demo.O.foto.DTO.HandDTO;
import com.example.demo.O.foto.DTO.HomeworkDTO;
import com.example.demo.O.foto.entiry.Homework;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeworkService {
    List<Homework> get();   //获取所有作业

    void insert(HomeworkDTO homeworkDTO);   //插入作业

    void delete(int id);

    void hand(HandDTO handDTO);
}

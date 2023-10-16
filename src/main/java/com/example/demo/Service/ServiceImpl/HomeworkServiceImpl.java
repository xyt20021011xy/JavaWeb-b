package com.example.demo.Service.ServiceImpl;

import com.example.demo.Mapper.HomeworkMapper;
import com.example.demo.O.foto.DTO.HandDTO;
import com.example.demo.O.foto.DTO.HomeworkDTO;
import com.example.demo.O.foto.VO.HandVO;
import com.example.demo.O.foto.entiry.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements com.example.demo.Service.HomeworkService{
    @Autowired
    private HomeworkMapper homeworkMapper;

    @Override
    public List<Homework> get() {
        return homeworkMapper.get();
    }

    @Override
    public void insert(HomeworkDTO homeworkDTO) {
        homeworkMapper.insert(homeworkDTO);
    }

    @Override
    public void delete(int id) {
        homeworkMapper.delete(id);
    }

    @Override
    public void hand(HandDTO handDTO) {
        homeworkMapper.hand(handDTO);
    }

    @Override
    public List<HandVO> getHand(String homeid) {
        List<HandVO>list=homeworkMapper.getHand(homeid);
        return list;
    }
}

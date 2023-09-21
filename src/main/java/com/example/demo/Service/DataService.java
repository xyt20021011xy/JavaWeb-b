package com.example.demo.Service;

import com.example.demo.O.foto.VO.DailyAcVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataService {
    List<DailyAcVO> getdata();

    void top(String name);

    List<String> topday();

    List<String> topmonth();
}

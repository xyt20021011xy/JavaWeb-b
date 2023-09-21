package com.example.demo.Service.ServiceImpl;

import com.example.demo.O.foto.VO.DailyAcVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class DataServiceImpl implements com.example.demo.Service.DataService {
    @Autowired
    private com.example.demo.Mapper.DataMapper dataMapper;

    /**
     * 获取日活量
     * @return
     */
    @Override
    public List<DailyAcVO> getdata() {
        List<DailyAcVO> list =new ArrayList<>();
        LocalDate localDate=LocalDate.now();
        for(int i=0;i<7;i++){
            DailyAcVO dailyAcVO=new DailyAcVO();
            dailyAcVO.setDate(localDate);
            if(dataMapper.getDaily(localDate)==null){
                dailyAcVO.setDailycount(0);
            }
            else{
                dailyAcVO.setDailycount((int)dataMapper.getDaily(localDate));
            }

            list.add(dailyAcVO);
            localDate=localDate.plusDays(-1);
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 点击量
     * @param name
     */
    @Override
    public void top(String name) {
        LocalDate localDate=LocalDate.now();
        if(dataMapper.getTop(name,localDate)==null){
            dataMapper.insertTop(name,localDate,1);
        }
        else{
            dataMapper.updateTop(name,(int)dataMapper.getTop(name,localDate)+1,localDate);
        }
    }

    @Override
    public List<String> topday() {
        LocalDate localDate=LocalDate.now();
        List<String> list=dataMapper.getTopday(localDate);
        return list;
    }

    @Override
    public List<String> topmonth() {
        List<String> list=dataMapper.getTopmonth();
        return list;
    }
}

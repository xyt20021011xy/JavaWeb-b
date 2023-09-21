package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DataMapper {
    @Select("select dailycount from dailyactivity where date=#{localDate}")
    Object getDaily(LocalDate localDate);
    @Select("SELECT count FROM top WHERE name=#{name} and date=#{localDate}")
    Object getTop(String name, LocalDate localDate);
    @Insert("INSERT INTO top(name,date,count) VALUES(#{name},#{localDate},#{i})")
    void insertTop(String name, LocalDate localDate, int i);
    @Update("UPDATE top SET count=#{i} WHERE name=#{name} and date=#{localDate}")
    void updateTop(String name, int i, LocalDate localDate);
    @Select("SELECT name FROM top WHERE date=#{localDate} ORDER BY count DESC LIMIT 20")
    List<String> getTopday(LocalDate localDate);
    @Select("SELECT name FROM top ORDER BY count DESC LIMIT 20")
    List<String> getTopmonth();
}

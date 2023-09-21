package com.example.demo.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Mapper
public interface LoginMapper {

    @Select("select password from form where username=#{username}")
    String selectPassword(String username);
    @Select("select count from use_data where username=#{username}")
    Object recordget(String username);
    @Insert("insert into use_data (username,name,count,date) values (#{username},#{name},#{count},#{localDate})")
    void recordinsert(String username, int count, String name, LocalDate localDate);
    @Update("update use_data set count=#{i},date=#{localDate} where username=#{username}")
    void recordupdate(String username, int i,LocalDate localDate);
    @Select("select name from form where username=#{username}")
    String getname(String username);
    @Select("select dailycount from dailyactivity where date=#{localDate}")
    Object recorddaily(LocalDate localDate);
    @Insert("insert into dailyactivity (date,dailycount) values (#{localDate},#{i})")
    void recordinsertDaily(LocalDate localDate, int i);
    @Update("update dailyactivity set dailycount=#{i} where date=#{localDate}")
    void recordupdateDaily(LocalDate localDate, int i);
}

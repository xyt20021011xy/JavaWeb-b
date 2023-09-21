package com.example.demo.Mapper;

import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.VO.UserVO;
import com.example.demo.O.foto.entiry.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FormMapper {

    Page<UserVO> page(UserDTO userDTO);
    @Delete("delete from form where username=#{username}")
    void delete(String username);
    @Update("update form set name=#{name}, sex=#{sex}, username=#{username}, password=#{password}, phone=#{phone} where id=#{id}")
    void update(User user);
    @Insert("INSERT INTO form (name, sex, username, password, phone, time) VALUES (#{name}, #{sex}, #{username}, #{password}, #{phone}, #{time})")
    void insert(User user);
    @Select("select name,count from use_data order by count desc limit 5")
    List<DateVO> get();
}

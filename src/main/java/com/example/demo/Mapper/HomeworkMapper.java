package com.example.demo.Mapper;

import com.example.demo.O.foto.DTO.HandDTO;
import com.example.demo.O.foto.DTO.HomeworkDTO;
import com.example.demo.O.foto.VO.HandVO;
import com.example.demo.O.foto.entiry.Homework;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface HomeworkMapper {
    @Select("select * from ` homework`")
    List<Homework> get();
    @Insert("insert into ` homework`(teacher,details,starttime,endtime,studentlist) values(#{teacher},#{details},#{starttime},#{endtime},#{studentlist})")
    void insert(HomeworkDTO homeworkDTO);
    @Delete("delete from ` homework` where id=#{id}")
    void delete(int id);
    @Insert("insert into `workstu`(homeid,username,content) values(#{homeid},#{username},#{content})")
    void hand(HandDTO handDTO);
    @Select("select * from `workstu` where homeid=#{homeid}")
    List<HandVO> getHand(String homeid);
}

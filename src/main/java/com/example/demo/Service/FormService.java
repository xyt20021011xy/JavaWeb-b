package com.example.demo.Service;

import com.example.demo.O.PageResult;
import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.VO.UserVO;
import com.example.demo.O.foto.entiry.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    PageResult getForm(UserDTO userDTO);

    void delete(String username);

    String update(User user);

    String insert(User user);

    List<DateVO> get();
}

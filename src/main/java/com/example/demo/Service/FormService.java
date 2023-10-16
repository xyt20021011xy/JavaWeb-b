package com.example.demo.Service;

import com.example.demo.O.foto.entiry.PageResult;
import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.entiry.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    PageResult getForm(UserDTO userDTO,String is);

    void delete(String username,String is);

    String update(User user,String is);

    String insert(User user,String is);

    List<DateVO> get(String is);
}

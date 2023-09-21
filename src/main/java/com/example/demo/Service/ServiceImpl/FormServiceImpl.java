package com.example.demo.Service.ServiceImpl;

import com.example.demo.O.PageResult;
import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.VO.UserVO;
import com.example.demo.O.foto.entiry.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class FormServiceImpl implements com.example.demo.Service.FormService{
    @Autowired
    private com.example.demo.Mapper.FormMapper formMapper;

    /**
     * 分页查询
     * @param userDTO
     * @return
     */
    @Override
    public PageResult getForm(UserDTO userDTO) {
        PageHelper.startPage(userDTO.getPage(),userDTO.getPageSize());
        Page<UserVO> page= formMapper.page(userDTO);

        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 删除
     * @param username
     */

    @Override
    public void delete(String username) {
        formMapper.delete(username);
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public String update(User user) {
        try {
            formMapper.update(user);
        }catch (Exception e){
            e.printStackTrace();
            return "用户名已经存在，请重新输入";
        }
        return "修改成功";

    }

    public String insert(User user) {
        try {
            formMapper.insert(user);
        }catch (Exception e){
            e.printStackTrace();
            return "用户名已经存在，请重新输入";
        }
        return "添加成功";

    }

    @Override
    public List<DateVO> get() {
        return formMapper.get();
    }

}

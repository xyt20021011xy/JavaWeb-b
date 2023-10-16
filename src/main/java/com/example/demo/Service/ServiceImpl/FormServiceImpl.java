package com.example.demo.Service.ServiceImpl;

import com.example.demo.O.foto.entiry.PageResult;
import com.example.demo.O.foto.DTO.UserDTO;
import com.example.demo.O.foto.VO.DateVO;
import com.example.demo.O.foto.VO.UserVO;
import com.example.demo.O.foto.entiry.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements com.example.demo.Service.FormService{
    @Autowired
    private com.example.demo.Mapper.FormMapper formMapper;
    /**
     * 参数is:1为学生，0为老师
     */
    public static String is(String is){
        if(is.equals("1")){
            return "form";
        }else{
            return "teacher";
        }
    }
    /**
     * 分页查询
     * @param userDTO
     * @return
     */
    @Override
    public PageResult getForm(UserDTO userDTO,String is) {
        PageHelper.startPage(userDTO.getPage(),userDTO.getPageSize());
        if(is.equals("1")){
            Page<UserVO> page= formMapper.page(userDTO);
            return new PageResult(page.getTotal(),page.getResult());
        }else {
            Page<UserVO> page= formMapper.page0(userDTO);
            return new PageResult(page.getTotal(),page.getResult());
        }

    }

    /**
     * 删除
     * @param username
     */

    @Override
    public void delete(String username,String is) {
        formMapper.delete(username,is(is));
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public String update(User user,String is) {
        try {
            if(is.equals("1")){
                formMapper.update(user);
            }
            else{
                formMapper.update0(user);
            }


        }catch (Exception e){
            e.printStackTrace();
            return "用户名已经存在，请重新输入";
        }
        return "修改成功";

    }

    public String insert(User user,String is) {
        try {
            if(is.equals("1"))
                formMapper.insert(user);
            else
                //System.out.println(is(is)
            formMapper.insert0(user);
        }catch (Exception e){
            e.printStackTrace();
            return "用户名已经存在，请重新输入";
        }
        return "添加成功";

    }

    @Override
    public List<DateVO> get(String is) {
        return formMapper.get();
    }

}

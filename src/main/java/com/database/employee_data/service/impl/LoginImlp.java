package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.EmployeeMapper;
import com.database.employee_data.mapper.LoginMapper;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.login;
import com.database.employee_data.service.EmployeeService;
import com.database.employee_data.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Arrays;
import java.util.List;

/**
 * @Author BMQAQ
 * @Date 2023/6/12 23:17
 * @Version 1.0
 */
@Service
public class LoginImlp implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Integer getById(String Eno)
    {
        return  loginMapper.getById(Eno);
    }
    @Override
    public boolean login(String Eno,String Userpasswd){
        return loginMapper.getByUsernameAndPassword(Eno,Userpasswd);
    }
    @Override
    public void update(String Eno, String Userpasswd){
        loginMapper.update(Eno,Userpasswd);
    }
    @Override
    public  String getphoto(String Eno){
        return loginMapper.getphoto(Eno);
    }
}

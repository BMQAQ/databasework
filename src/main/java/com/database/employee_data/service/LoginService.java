package com.database.employee_data.service;

import com.database.employee_data.pojo.login;
import org.springframework.stereotype.Service;

/**
 * @Author BMQAQ
 * @Date 2023/6/12 23:15
 * @Version 1.0
 */
public interface LoginService {
    boolean login(String Eno,String Userpasswd);
    Integer getById(String Eno);

    String getphoto(String Eno);

    void update(String Eno, String Userpasswd);
}

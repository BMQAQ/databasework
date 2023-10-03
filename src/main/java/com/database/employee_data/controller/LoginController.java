package com.database.employee_data.controller;

import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.login;
import com.database.employee_data.service.EmployeeService;
import com.database.employee_data.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @Author BMQAQ
 * @Date 2023/6/12 22:51
 * @Version 1.0
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login/{Eno}/{Userpasswd}")
    public Rusult login(@PathVariable String Eno, @PathVariable String Userpasswd){
        log.info("登录");
        log.info(Eno+Userpasswd);
        boolean a=loginService.login(Eno,Userpasswd);

        return a!=false?Rusult.success():Rusult.error("用户名或密码错误");
    }

    @GetMapping("/login/{Eno}")
    public Rusult getById(@PathVariable  String Eno){
        log.info("根据ID查询");
        Integer a=loginService.getById(Eno);
        return  Rusult.success(a);
    }
    @PostMapping("/login1/{Eno}/{Userpasswd}")
    public Rusult update(@PathVariable  String Eno,@PathVariable String Userpasswd){
        log.info("根据ID查询");
        loginService.update(Eno,Userpasswd);
        return  Rusult.success();
    }
    @GetMapping("/login1/{Eno}")
    public Rusult getphoto(@PathVariable  String Eno){
        String postion = loginService.getphoto(Eno);
        return Rusult.success(postion);
    }

}

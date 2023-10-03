package com.database.employee_data.service;


import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;

import java.util.List;
public interface EmployeeService {
    List<employee> list();

    void delete(String id);

    void add(employee emp);

    PageBean page(Integer page, Integer pagesize,String Eid,String name,String sex);

    employee getById(String Eno);

    void update(String Eno,String Ename,String Epos,String Ephone,String Esex,String Eid);

    String getphoto(String Eno);
}

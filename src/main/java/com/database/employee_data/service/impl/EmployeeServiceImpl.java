package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.EmployeeMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper EmpMapper;
    @Override
    public List<employee> list() {
        return EmpMapper.list();
    }
    @Override
    public void delete(String id){
        EmpMapper.deleteByID(id);
    }
    @Override
    public void add(employee emp)
    {
        EmpMapper.insert(emp);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize,String Eno,String name,String sex)
    {
        PageHelper.startPage(page,pagesize);
        List<employee> employeeList=EmpMapper.list1(Eno,name,sex);
        Page<employee> p=(Page<employee>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
    @Override
    public employee getById(String Eno)
    {
        return  EmpMapper.getById(Eno);
    }
    @Override
    public void update(String Eno,String Ename,String Epos,String Ephone,String Esex,String Eid)
    {
        EmpMapper.update(Eno,Ename,Epos,Ephone,Esex,Eid);
    }
    @Override
    public String getphoto(String Eno)
    {
        return  EmpMapper.getphoto(Eno);
    }
}

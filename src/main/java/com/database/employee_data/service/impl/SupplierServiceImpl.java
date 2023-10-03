package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.SupplierMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Supplier;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.service.SupplierService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper Supmapper;
    @Override
    public List<Supplier> list() {

        return Supmapper.list();
    }
    @Override
    public void add(Supplier supplier)
    {
        Supmapper.insert(supplier);
    }
    @Override
    public void delete(String Sno){
        Supmapper.deleteBySno(Sno);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize, String Sno, String Sname, String Sphone)
    {
        PageHelper.startPage(page,pagesize);
        List<Supplier> employeeList=Supmapper.list1(Sno,Sname,Sphone);
        Page<Supplier> p=(Page<Supplier>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
    @Override
    public void update(String Sno,String Sname,String Sphone,String Sadress)
    {
        Supmapper.update(Sno,Sname,Sphone,Sadress);
    }
}

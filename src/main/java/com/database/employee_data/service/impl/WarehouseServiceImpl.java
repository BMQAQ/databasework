package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.WarehouseMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.warehouse;
import com.database.employee_data.service.WarehouseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Override
    public List<warehouse> list() {

        return warehouseMapper.list();
    }
    @Override
    public void delete(String Wno){
        warehouseMapper.deleteByID(Wno);
    }
    @Override
    public void add(warehouse warehouse)
    {
        warehouseMapper.insert(warehouse);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize,String Wno,String Wphone)
    {
        PageHelper.startPage(page,pagesize);
        List<warehouse> employeeList=warehouseMapper.list1(Wno,Wphone);
        Page<warehouse> p=(Page<warehouse>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

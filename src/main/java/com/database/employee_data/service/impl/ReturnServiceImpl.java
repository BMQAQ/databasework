package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.ReturnMapper;
import com.database.employee_data.mapper.SupplierMapper;
import com.database.employee_data.pojo.*;
import com.database.employee_data.service.ReturnService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnMapper returnMapper;
    @Override
    public List<Return> list() {

        return returnMapper.list();
    }
    @Override
    public void delete(String ROno,String goodsid){
        returnMapper.delete(ROno,goodsid);
    }
    @Override
    public void add1(Return Return)
    {
        returnMapper.insert(Return);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize, String ROno, String goods_id)
    {
        PageHelper.startPage(page,pagesize);
        List<Return> employeeList=returnMapper.list1(ROno,goods_id);
        Page<Return> p=(Page<Return>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

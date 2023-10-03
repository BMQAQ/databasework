package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.Goods_SalesMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.service.Goods_SalesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Goods_SalesImpl implements Goods_SalesService {
    @Autowired
    private Goods_SalesMapper goodsSalesMapper;
    @Override
    public List<goods_sales> list(){

        return goodsSalesMapper.list();
    }
    @Override
    public void delete(String saleid,String goodsid){
        goodsSalesMapper.delete(saleid,goodsid);
    }

    @Override
    public void add(goods_sales goodsSales)
    {
        goodsSalesMapper.insert(goodsSales);
    }
    public PageBean page(Integer page, Integer pagesize, String saleid, String goodsid, String wno, Date begin,Date end)
    {
        PageHelper.startPage(page,pagesize);
        List<goods_sales> employeeList=goodsSalesMapper.list1(saleid,goodsid,wno,begin,end);
        Page<goods_sales> p=(Page<goods_sales>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

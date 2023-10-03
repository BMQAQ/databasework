package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.PurchaseMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.purchase;
import com.database.employee_data.service.PurchaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Override
    public List<purchase> list() {

        return purchaseMapper.list();
    }
    @Override
    public void delete(String POno,String goodsid){
        purchaseMapper.delete(POno,goodsid);
    }

    @Override
    public void add1(purchase purchase)
    {
        purchaseMapper.insert(purchase);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize, String POno,String goods_id)
    {
        PageHelper.startPage(page,pagesize);
        List<purchase> employeeList=purchaseMapper.list1(POno,goods_id);
        Page<purchase> p=(Page<purchase>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

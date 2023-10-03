package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.Goods_WarehouseMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.goods_warehouse;
import com.database.employee_data.pojo.warehouse;
import com.database.employee_data.service.Goods_WarehouseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goods_WarehouseImpl implements Goods_WarehouseService {
    @Autowired
    private Goods_WarehouseMapper goodsWarehouseMapper;
    @Override
    public List<goods_warehouse> list(){

        return goodsWarehouseMapper.list();
    }
    @Override
    public void delete(String wno, String goodsid){
        goodsWarehouseMapper.deleteByID(wno,goodsid);
    }
    @Override
    public void add(goods_warehouse goods_warehouse)
    {
        goodsWarehouseMapper.insert(goods_warehouse);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize,String goods_id,String Wno)
    {
        PageHelper.startPage(page,pagesize);
        List<goods_warehouse> employeeList=goodsWarehouseMapper.list1(goods_id,Wno);
        Page<goods_warehouse> p=(Page<goods_warehouse>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
    @Override
    public void update(String goods_id, String Wno, String Wsave)
    {
        goodsWarehouseMapper.update(goods_id,Wno,Wsave);
    }

}

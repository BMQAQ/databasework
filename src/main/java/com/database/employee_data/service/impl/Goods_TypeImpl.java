package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.GoodsTypeMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.goods;
import com.database.employee_data.pojo.type;
import com.database.employee_data.service.Goods_typeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goods_TypeImpl implements Goods_typeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Override
    public List<type> list(){
        return goodsTypeMapper.list();
    }
    @Override
    public void delete(String TYno) {
        goodsTypeMapper.delete(TYno);
    }
    @Override
    public void add(type type)
    {
        goodsTypeMapper.insert(type);
    }
    public PageBean page(Integer page, Integer pagesize, String typeid,String typename)
    {
        PageHelper.startPage(page,pagesize);
        List<type> employeeList=goodsTypeMapper.list1(typeid,typename);
        Page<type> p=(Page<type>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
    @Override
    public void update(String typeid,String typename)
    {
        goodsTypeMapper.update(typeid,typename);
    }
}

package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.GoodsMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Supplier;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.goods;
import com.database.employee_data.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<goods> list(){
        return goodsMapper.list();
    }
    @Override
    public void add(goods goods)
    {
        goodsMapper.insert(goods);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize, String Sno, String Sname)
    {
        PageHelper.startPage(page,pagesize);
        List<goods> employeeList=goodsMapper.list1(Sno,Sname);
        Page<goods> p=(Page<goods>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
    @Override
    public void update(String goods_id, String goods_name, String purchase_price, String sale_price, String keepdate, String typeid, String Tunit)
    {
        goodsMapper.update(goods_id, goods_name, purchase_price, sale_price,  keepdate, typeid, Tunit);
    }
}

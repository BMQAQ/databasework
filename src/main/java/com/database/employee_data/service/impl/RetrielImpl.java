package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.RetrievalMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.purchase;
import com.database.employee_data.pojo.retrieval;
import com.database.employee_data.service.RetrievalService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrielImpl implements RetrievalService {
    @Autowired
    private RetrievalMapper retrievalMapper;
    @Override
    public List<retrieval> list() {

        return retrievalMapper.list();
    }
    @Override
    public void delete(String retrievalid,String goodsid,String wno){

        retrievalMapper.delete(retrievalid,goodsid,wno);
    }
    @Override
    public void add1(retrieval retrieval)
    {
        retrievalMapper.insert(retrieval);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize, String retrievalid, String goods_id)
    {
        PageHelper.startPage(page,pagesize);
        List<retrieval> employeeList=retrievalMapper.list1(retrievalid,goods_id);
        Page<retrieval> p=(Page<retrieval>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

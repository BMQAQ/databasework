package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.StorageMapper;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.purchase;
import com.database.employee_data.pojo.storage;
import com.database.employee_data.service.StorageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;
    @Override
    public List<storage> list() {

        return storageMapper.list();
    }
    @Override
    public void delete(String saleid,String goodsid,String wno){
        storageMapper.delete(saleid,goodsid,wno);
    }
    @Override
    public void add(storage storage)
    {
        storageMapper.insert(storage);
    }
    @Override
    public PageBean page(Integer page, Integer pagesize, String storageid, String goods_id)
    {
        PageHelper.startPage(page,pagesize);
        List<storage> employeeList=storageMapper.list1(storageid,goods_id);
        Page<storage> p=(Page<storage>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

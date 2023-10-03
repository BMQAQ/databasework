package com.database.employee_data.service.impl;

import com.database.employee_data.mapper.MoVeMapper;
import com.database.employee_data.mapper.SupplierMapper;
import com.database.employee_data.pojo.*;
import com.database.employee_data.service.MoVeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoVeServiceImlp implements MoVeService {
    @Autowired
    private MoVeMapper moVeMapper;
    @Override
    public List<MoVe> list() {

        return moVeMapper.list();
    }
    @Override
    public void delete(String moveid,String goodsid,String Win,String Wout) {
        moVeMapper.delete(moveid, goodsid, Win, Wout);
    }
    @Override
    public void add(MoVe move)
    {
        moVeMapper.insert(move);
    }
    public PageBean page(Integer page, Integer pagesize, String moveid, String goods_id,String win,String wout)
    {
        PageHelper.startPage(page,pagesize);
        List<MoVe> employeeList=moVeMapper.list1(moveid,goods_id,win,wout);
        Page<MoVe> p=(Page<MoVe>) employeeList;
        PageBean pageBean=new PageBean(p.getTotal(),p.getResult());
        return  pageBean;
    }
}

package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.goods;
import com.database.employee_data.pojo.type;

import java.util.List;

public interface Goods_typeService {
    List<type> list();

    void delete(String TYno);

    void add(type type);

    PageBean page(Integer page, Integer pagesize, String typeid, String typename);

    void update(String typeid, String typename);
}

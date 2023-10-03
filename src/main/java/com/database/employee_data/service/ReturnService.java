package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Return;

import java.util.List;

public interface ReturnService {
    List<Return> list();

    void delete(String rOno, String goodsid);

    void add1(Return aReturn);

    PageBean page(Integer page, Integer pagesize, String ROno, String goods_id);
}

package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.goods_sales;

import java.util.Date;
import java.util.List;

public interface Goods_SalesService {
    List<goods_sales> list();

    void delete(String saleid, String goodsid);

    void add(goods_sales goodsSales);

    PageBean page(Integer page, Integer pagesize, String saleid, String goodsid, String wno, Date begin, Date end);
}

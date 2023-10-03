package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.goods;

import java.util.Date;
import java.util.List;

public interface GoodsService {
    List<goods> list();

    void add(goods goods);

    PageBean page(Integer page, Integer pagesize, String sno, String sname);

    void update(String goods_id, String goods_name, String purchase_price, String sale_price, String keepdate, String typeid, String Tunit);
}

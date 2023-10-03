package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.goods_warehouse;

import java.util.List;

public interface Goods_WarehouseService {
    List<goods_warehouse> list();

    void delete(String wno, String goodsid);

    void add(goods_warehouse goodsWarehouse);

    PageBean page(Integer page,Integer pagesize, String goods_id, String Wno);

    void update(String goods_id, String Wno, String Wsave);
}

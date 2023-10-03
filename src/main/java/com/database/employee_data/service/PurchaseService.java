package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.purchase;

import java.util.List;

public interface PurchaseService {
    List<purchase> list();


    void delete(String pOno, String goodsid);

    void add1(purchase purchase);

    PageBean page(Integer page, Integer pagesize, String POno, String goods_id);
}

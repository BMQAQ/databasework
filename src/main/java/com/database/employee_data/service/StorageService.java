package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.storage;

import java.util.List;

public interface StorageService {
    List<storage> list();

    void delete(String saleid, String goodsid,String wno);

    void add(storage storage);

    PageBean page(Integer page, Integer pagesize, String storageid, String goods_id);
}

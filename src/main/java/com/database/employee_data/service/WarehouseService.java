package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.warehouse;

import java.util.List;

public interface WarehouseService {
    List<warehouse> list();

    void delete(String wno);

    void add(warehouse warehouse);

    PageBean page(Integer page,Integer pagesize, String Wno, String Wphone);
}

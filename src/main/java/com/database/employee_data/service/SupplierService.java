package com.database.employee_data.service;

import java.util.List;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Supplier;

public interface SupplierService {
    List<Supplier> list();

    void add(Supplier supplier);

    void delete(String sno);

    PageBean page(Integer page, Integer pagesize, String sno, String sname, String sphone);

    void update(String Sno, String Sname, String Sphone, String Sadress);
}





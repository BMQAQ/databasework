package com.database.employee_data.service;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.retrieval;

import java.util.List;

public interface RetrievalService {
    List<retrieval> list();

    void delete(String retrievalid, String goodsid, String wno);

    void add1(retrieval retrieval);

    PageBean page(Integer page, Integer pagesize, String retrievalid, String goods_id);
}

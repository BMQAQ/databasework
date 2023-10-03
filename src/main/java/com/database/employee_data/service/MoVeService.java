package com.database.employee_data.service;

import com.database.employee_data.pojo.MoVe;
import com.database.employee_data.pojo.PageBean;

import java.util.List;

public interface MoVeService {
    List<MoVe> list();

    void delete(String moveid, String goodsid, String win, String wout);

    void add(MoVe move);

    PageBean page(Integer page, Integer pagesize, String moveid, String goods_id, String win, String wout);
}

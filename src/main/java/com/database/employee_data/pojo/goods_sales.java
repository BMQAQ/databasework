package com.database.employee_data.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class goods_sales {
    private String saleid;
    private String goodsid;
    private String wno;
    private Integer salenum;
    private Date sotime;
    private String eno;
}

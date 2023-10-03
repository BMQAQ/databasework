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
public class purchase {
    private String POno;
    private String goodsid;
    private String Sno;
    private String Wno;
    private Integer POnum;
    private Date POtime;
    private String Eno;




}

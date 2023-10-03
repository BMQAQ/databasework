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
public class retrieval {
    private String retrievalid;
    private String goodsid;
    private String Wno;
    private Integer retrievalnum;
    private Date retrievaltime;
    private String Eno;



}

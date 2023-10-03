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
public class storage {
    private String storageid;
    private String goodsid;
    private String Wno;
    private Integer storagenum;
    private Date storagetime;
    private String Eno;




}

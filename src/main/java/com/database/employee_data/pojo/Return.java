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
public class Return {
    private String ROno;


    private String goodsid;
    private String Wno;
    private Integer ROnum;
    private String reason;
    private Date ROtime;
    private String Eno;

}

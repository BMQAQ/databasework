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
public class MoVe {
    private String moveid;
    private String goodsid;
    private String win;
    private String wout;
    private Integer movenum;
    private Date movetime;

    private String eno;
}

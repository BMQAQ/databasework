package com.database.employee_data.pojo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class goods {
    private String Goods_id;
    private String Goods_name;
    private Float Purchase_price;
    private Float Sale_price;
    private String keepdate;
    private String TYno;
    private String unit;

}

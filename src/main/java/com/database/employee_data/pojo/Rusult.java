package com.database.employee_data.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rusult {
    private  Integer code;
    private  String msg;
    private Object data;
    public static Rusult success()
    {
        return new Rusult(1,"success",null);
    }
    public static Rusult success(Object data)
    {
        return new Rusult(1,"success",data);
    }
    public static Rusult error(String msg)
    {
        return new Rusult(0,msg,null);
    }
}

package com.database.employee_data.mapper;

import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.goods_warehouse;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface Goods_WarehouseMapper {
    @Select("select *from goods_warehouse order by CAST(goods_id AS INT)asc   ")
    List<goods_warehouse> list();
    @Delete("delete from goods_warehouse where goods_id=#{goodsid} and Wno=#{wno}")
    void deleteByID(String wno, String goodsid);

    @Insert("insert into goods_warehouse (goods_id, Wno, Wsave) values (#{Tno}, #{Wno}, #{Wsave})")
    void insert(goods_warehouse goodsWarehouse);

    List<goods_warehouse> list1(String goods_id, String Wno);
    @Update("UPDATE goods_warehouse SET Wsave=#{Wsave} WHERE Wno=#{Wno} and goods_id=#{goods_id}")
    void update(String goods_id, String Wno, String Wsave);
}

package com.database.employee_data.mapper;

import com.database.employee_data.pojo.goods_sales;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
@Mapper
public interface Goods_SalesMapper {
    @Select("select * from sale order by CAST(saleid AS INT)asc  ")
    List<goods_sales> list();
    @Delete("delete from sale where saleid=#{saleid} and goodsid=#{goodsid};")
    void delete(String saleid, String goodsid);

    @Insert("insert into sale (saleid, goodsid,Wno,salenum,SOtime,Eno) values (#{saleid}, #{goodsid},#{wno},#{salenum}, #{sotime},#{eno})")
    void insert(goods_sales goodsSales);

    List<goods_sales> list1(String saleid, String goodsid, String wno, Date begin, Date end);
}


package com.database.employee_data.mapper;

import com.database.employee_data.pojo.Supplier;
import com.database.employee_data.pojo.goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("SELECT * FROM goods ORDER BY CAST(goods_id AS INTEGER) ASC;")
    List<goods> list();
    @Insert("insert into goods (goods_id, goods_name, purchase_price, sale_price,  keepdate,typeid,Tunit) values (#{Goods_id}, #{Goods_name}, #{Purchase_price}, #{Sale_price},  #{keepdate},#{TYno},#{unit})")
    void insert(goods goods);

    List<goods> list1(String goodsId, String goodsName);
    @Update("UPDATE goods SET  goods_name=#{goods_name}, purchase_price=#{purchase_price}, sale_price=#{sale_price}, keepdate=#{keepdate}, typeid=#{typeid}, Tunit=#{Tunit} WHERE goods_id=#{goods_id}")
    void update(String goods_id, String goods_name, String purchase_price, String sale_price, String keepdate, String typeid, String Tunit);
}

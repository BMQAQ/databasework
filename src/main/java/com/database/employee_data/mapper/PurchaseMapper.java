package com.database.employee_data.mapper;

import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.purchase;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PurchaseMapper {

    @Select("select * from purchase order by CAST(POno AS INT) asc")
    List<purchase> list();

    @Delete("delete from purchase where POno=#{POno} and goodsid=#{goodsid};")
    void delete(String POno, String goodsid);

    @Insert("insert into purchase (POno, goodsid,Sno,Wno,POnum,POtime,Eno) values (#{POno}, #{goodsid},#{Sno},#{Wno},#{POnum},#{POtime},#{Eno})")
    void insert(purchase Purchase);

    List<purchase> list1(String POno, String goods_id);
}

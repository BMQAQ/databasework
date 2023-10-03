package com.database.employee_data.mapper;

import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.storage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StorageMapper {
    @Select("select *from storage order by CAST(storage.storageid AS INT)asc")
    List<storage> list();

    @Delete("delete from storage where storageid=#{saleid} and goodsid=#{goodsid} and Wno=#{wno};")
    void delete(String saleid, String goodsid, String wno);

    @Insert("insert into storage (storageid, goodsid,Wno,storagenum,storagetime,Eno)) values (#{storageid}, #{goodsid},#{wno},#{storagenum}, #{storagetime},#{eno})")
    void insert(storage storage);


    List<storage> list1(String storageid, String goods_id);
}

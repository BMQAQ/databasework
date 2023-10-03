package com.database.employee_data.mapper;

import com.database.employee_data.pojo.warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    @Select("SELECT * FROM warehouse ORDER BY CAST(Wno AS INT) ASC;")
    List<warehouse> list();
    @Delete("delete from warehouse where Wno=#{wno}")
    void deleteByID(String wno);
    @Insert("insert into warehouse (Wno,Wadress,Wphone,Wmanager) values (#{Wno}, #{Wadress}, #{Wphone}, #{Wmanager})")
    void insert(warehouse warehouse);

    List<warehouse> list1(String Wno, String Wphone);
}

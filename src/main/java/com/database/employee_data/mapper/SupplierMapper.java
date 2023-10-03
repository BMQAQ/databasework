package com.database.employee_data.mapper;

import com.database.employee_data.pojo.Supplier;
import com.database.employee_data.pojo.employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SupplierMapper {
    @Select("select * from supplier")
    List<Supplier> list();

    @Insert("insert into supplier " +
            "(Sno, Sname,Sphone, Sadress) values " +
            "(#{Sno}, #{Sname}, #{Sphone}, #{Sadress})")
    void insert(Supplier supplier);
    @Delete("delete from supplier where Sno=#{sno}")
    void deleteBySno(String sno);
    List<Supplier> list1(String Sno, String Sname, String Sphone);
    @Update("UPDATE supplier SET Sname=#{Sname},  Sphone=#{Sphone}, Sadress=#{Sadress} WHERE Sno=#{Sno}")
    void update(String Sno, String Sname, String Sphone, String Sadress);
}

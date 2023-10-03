package com.database.employee_data.mapper;

import org.apache.ibatis.annotations.*;
import com.database.employee_data.pojo.employee;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee")
    List<employee> list();

    //@Select("select * from employee")

    List<employee> list1(String Eno,String name,String sex);

    @Delete("delete from employee where Eno=#{id}")
    void deleteByID(String id);

    @Insert("insert into employee (Eno, Ename, Epos, Ephone, Esex, Eid,photo) values (#{Eno}, #{Ename}, #{Epos}, #{Ephone}, #{Esex}, #{Eid},#{photo})")
    void insert(employee emp);
    @Select("select *from shop_database.dbo.employee where Eno=#{Eno}")
    employee getById(String Eno);


    @Update("UPDATE employee SET Ename=#{Ename}, Epos=#{Epos}, Ephone=#{Ephone}, Esex=#{Esex}, Eid=#{Eid} WHERE Eno=#{Eno}")
    void update(String Eno, String Ename, String Epos, String Ephone, String Esex, String Eid);

    @Select("select photo from shop_database.dbo.employee where Eno=#{Eno}")
    String getphoto(String Eno);

    /*@Select("select count(*) from employee")
    public Long count();
    @Select("SELECT *\n" +
            "FROM employee\n" +
            "ORDER BY (SELECT NULL)\n" +
            "OFFSET #{start} ROWS\n" +
            "FETCH NEXT #{pagesize} ROWS ONLY;\n")

    */

}


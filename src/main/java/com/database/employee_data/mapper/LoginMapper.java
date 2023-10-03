package com.database.employee_data.mapper;

import com.database.employee_data.pojo.login;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Blob;

/**
 * @Author BMQAQ
 * @Date 2023/6/12 23:19
 * @Version 1.0
 */
@Mapper
public interface LoginMapper {
    @Select("SELECT COUNT(*) FROM shop_database.dbo.login WHERE Userpasswd=#{Userpasswd} AND Eno=#{Eno}")
    boolean getByUsernameAndPassword(String Eno,String Userpasswd);
    @Select("select Upos from shop_database.dbo.login where Eno=#{Eno}")
    Integer getById(String Eno);

    @Update("UPDATE login SET Userpasswd=#{Userpasswd} WHERE Eno=#{Eno}")
    void update(String Eno,String Userpasswd);

    @Select("SELECT Picture FROM shop_database.dbo.login WHERE Eno = #{eno}")
    String getphoto(String eno);

}

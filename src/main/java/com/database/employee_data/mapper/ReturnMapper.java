package com.database.employee_data.mapper;

import com.database.employee_data.pojo.Return;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ReturnMapper {
    @Select("select *from return_data order by CAST(ROno AS INT)asc")
    List<Return> list();
    @Delete("delete from return_data where ROno=#{ROno} and goodsid=#{goodsid};")
    void delete(String ROno, String goodsid);
    @Insert("insert into return_data (ROno, goodsid,Wno,ROnum,reason,ROtime,Eno) values (#{ROno}, #{goodsid},#{Wno},#{ROnum},#{reason},#{ROtime},#{Eno})")
    void insert(Return aReturn);

    List<Return> list1(String ROno, String goods_id);
}

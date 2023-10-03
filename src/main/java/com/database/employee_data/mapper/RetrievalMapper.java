package com.database.employee_data.mapper;

import com.database.employee_data.pojo.retrieval;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface RetrievalMapper {
    @Select("select * from retrieval order by CAST(retrievalid AS INT)asc")
    List<retrieval> list();

    @Delete("delete from retrieval where retrievalid=#{retrievalid} and goodsid=#{goodsid} and Wno=#{wno};")
    void delete(String retrievalid, String goodsid,String wno) ;
    @Insert("insert into retrieval (retrievalid, goodsid,Wno,retrievalnum,retrievaltime,Eno) values (#{retrievalid}, #{goodsid},#{Wno},#{retrievalnum},#{retrievaltime},#{Eno})")
    void insert(retrieval retrieval);

    List<retrieval> list1(String retrievalid, String goods_id);
}

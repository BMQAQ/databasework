package com.database.employee_data.mapper;

import com.database.employee_data.pojo.MoVe;
import com.database.employee_data.pojo.goods_warehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MoVeMapper {
    @Select("select * from Move_real order by CAST(moveid AS INT)asc")
    List<MoVe> list();
    @Delete("delete from Move_real where moveid=#{moveid} and goodsid=#{goodsid} and Win=#{win} and Wout=#{wout};")
    void delete(String moveid, String goodsid, String win, String wout);
    @Insert("insert into Move_real (moveid, goodsid,Wout,Win,movenum,movetime,Eno) values (#{moveid}, #{goodsid},#{wout},#{win},#{movenum},#{movetime},#{eno})")
    void insert(MoVe move);

    List<MoVe> list1(String moveid, String goods_id, String win, String wout);
}

package com.database.employee_data.mapper;

import com.database.employee_data.pojo.goods;
import com.database.employee_data.pojo.type;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsTypeMapper {
    @Select("select * from type order by CAST(typeid AS INT)asc ")
    List<type> list();
    @Delete("delete from type where typeid=#{typeid} ;")
    void delete(String TYno);
    @Insert("insert into type (typeid, typename) values (#{TYno}, #{TYname})")
    void insert(type type);

    List<type> list1(String typeid, String typename);
    @Update("UPDATE type SET typename=#{typename} WHERE typeid=#{typeid}")
    void update(String typeid, String typename);
}

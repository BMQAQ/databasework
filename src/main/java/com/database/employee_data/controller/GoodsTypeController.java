package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.goods;
import com.database.employee_data.pojo.type;
import com.database.employee_data.service.Goods_typeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class GoodsTypeController {
    @Autowired
    private Goods_typeService goodsTypeService;
    @GetMapping("/goodstype")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<type> goodsTypesList=goodsTypeService.list();
        return Rusult.success(goodsTypesList);
    }
    @DeleteMapping("/goodstype/{TYno}")
    public Rusult delete(@PathVariable String TYno){
        log.info("删除员工:{},{}",TYno);
        goodsTypeService.delete(TYno);
        return Rusult.success();
    }
    @PostMapping("/goodstype")
    public Rusult add(@RequestBody type type)
    {
        log.info("新增商品：{}",type);
        goodsTypeService.add(type);
        return Rusult.success();
    }
    @GetMapping("/goodstype1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String typeid,String typename){
        log.info("分页查询成功");
        PageBean pageBean=goodsTypeService.page(page,pagesize,typeid,typename);
        return Rusult.success(pageBean);
    }
    @PostMapping("/goodstype/{typeid}/{typename}")
    public  Rusult update(@PathVariable  String typeid,@PathVariable  String typename){
        log.info("更新员工信息");
        goodsTypeService.update(typeid,typename);
        return  Rusult.success();
    }

}

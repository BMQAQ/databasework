package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.goods_warehouse;
import com.database.employee_data.service.Goods_WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class Goods_WarehouseController {
    @Autowired
    private Goods_WarehouseService goodsWarehouseService;
    @GetMapping("/goods_warehouse")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<goods_warehouse> goodsTypesList=goodsWarehouseService.list();
        return Rusult.success(goodsTypesList);
    }
    @DeleteMapping("/goods_warehouse/{Wno}/{goodsid}")
    public Rusult delete(@PathVariable String Wno,@PathVariable String goodsid){
        log.info("删除员工:{},{}",Wno,goodsid);
        goodsWarehouseService.delete(Wno,goodsid);
        return Rusult.success();
    }
    @PostMapping("/goods_warehouse")
    public Rusult add(@RequestBody goods_warehouse goods_warehouse)
    {
        log.info("新增部门：{}",goods_warehouse);
        goodsWarehouseService.add(goods_warehouse);
        return Rusult.success();
    }
    @GetMapping("/goods_warehouse1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String goods_id,String Wno){
        log.info("分页查询成功");
        PageBean pageBean=goodsWarehouseService.page(page,pagesize,goods_id,Wno);
        return Rusult.success(pageBean);
    }
    @PostMapping("/goods_warehouse/{goods_id}/{Wno}/{Wsave}")
    public  Rusult update(@PathVariable  String goods_id,@PathVariable  String Wno,@PathVariable  String Wsave){
        log.info("更新员工信息");
        goodsWarehouseService.update(goods_id,Wno,Wsave);
        return  Rusult.success();
    }
}

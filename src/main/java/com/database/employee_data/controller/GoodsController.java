package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.Supplier;
import com.database.employee_data.pojo.goods;
import com.database.employee_data.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("/goods")
    public Rusult list()
    {
        log.info("查询全部商品信息");
        List<goods> goodsList=goodsService.list();
        return Rusult.success(goodsList);
    }
    @PostMapping("/goods")
    public Rusult add(@RequestBody goods goods)
    {
        log.info("新增商品：{}",goods);
        goodsService.add(goods);
        return Rusult.success();
    }
    @GetMapping("/goods1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String goods_id,String goodsName){
        log.info("分页查询成功");
        PageBean pageBean=goodsService.page(page,pagesize,goods_id,goodsName);
        return Rusult.success(pageBean);
    }
    @PostMapping("/goods/{goods_id}/{goods_name}/{purchase_price}/{sale_price}/{keepdate}/{typeid}/{Tunit}")
    public  Rusult update(@PathVariable  String goods_id,@PathVariable  String goods_name,@PathVariable String purchase_price,@PathVariable String sale_price,@PathVariable String keepdate,@PathVariable String typeid,@PathVariable String Tunit){
        log.info("更新员工信息");
        goodsService.update(goods_id,goods_name,purchase_price,sale_price,keepdate,typeid,Tunit);
        return  Rusult.success();
    }
}

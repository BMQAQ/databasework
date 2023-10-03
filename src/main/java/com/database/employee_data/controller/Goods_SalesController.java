package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.type;
import com.database.employee_data.service.Goods_SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class Goods_SalesController {
    @Autowired
    private Goods_SalesService goodsSalesService;
    @GetMapping("/goods_sales")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<goods_sales> goodsTypesList=goodsSalesService.list();
        return Rusult.success(goodsTypesList);
    }
    @DeleteMapping("/goods_sales/{saleid}/{goodsid}")
    public Rusult delete(@PathVariable String saleid,@PathVariable String goodsid){
        log.info("删除员工:{},{}",saleid,goodsid);
        goodsSalesService.delete(saleid,goodsid);
        return Rusult.success();
    }
    @PostMapping("/goods_sales")
    public Rusult add1(@RequestBody goods_sales goodsSales)
    {
        log.info("新增商品：{}",goodsSales);
        goodsSalesService.add(goodsSales);
        return Rusult.success();
    }
    @GetMapping("/goods_sales1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String saleid, String goodsid,
                       String wno,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        log.info("分页查询成功");
        PageBean pageBean=goodsSalesService.page(page,pagesize,saleid,goodsid,wno,begin,end);
        return Rusult.success(pageBean);
    }
}

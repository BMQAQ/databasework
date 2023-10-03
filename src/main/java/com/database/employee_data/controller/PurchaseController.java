package com.database.employee_data.controller;

import com.database.employee_data.pojo.*;
import com.database.employee_data.service.MoVeService;
import com.database.employee_data.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @GetMapping("/purchase")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<purchase> purchaseList=purchaseService.list();
        return Rusult.success(purchaseList);
    }
    @DeleteMapping("/purchase/{POno}/{goodsid}")
    public Rusult delete(@PathVariable String POno,@PathVariable String goodsid){
        log.info("删除员工:{},{}",POno,goodsid);
        purchaseService.delete(POno,goodsid);
        return Rusult.success();
    }
    @PostMapping("/purchase")
    public Rusult add1(@RequestBody purchase purchase)
    {
        log.info("新增商品：{}",purchase);
        purchaseService.add1(purchase);
        return Rusult.success();
    }
    @GetMapping("/purchase1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                      String POno, String goods_id){
        log.info("分页查询成功");
        PageBean pageBean=purchaseService.page(page,pagesize,POno,goods_id);
        return Rusult.success(pageBean);
    }

}

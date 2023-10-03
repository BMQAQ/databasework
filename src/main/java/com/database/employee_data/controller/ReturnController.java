package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.Return;
import com.database.employee_data.pojo.purchase;
import com.database.employee_data.service.ReturnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class ReturnController {
    @Autowired
    private ReturnService returnService;
    @GetMapping("/return")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<Return> retrievalList=returnService.list();
        return Rusult.success(retrievalList);
    }
    @DeleteMapping("/return/{ROno}/{goodsid}")
    public Rusult delete(@PathVariable String ROno, @PathVariable String goodsid){
        log.info("删除员工:{},{}",ROno,goodsid);
        returnService.delete(ROno,goodsid);
        return Rusult.success();
    }
    @PostMapping("/return")
    public Rusult add1(@RequestBody Return Return)
    {
        log.info("新增商品：{}",Return);
        returnService.add1(Return);
        return Rusult.success();
    }
    @GetMapping("/return1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String ROno, String goods_id){
        log.info("分页查询成功");
        PageBean pageBean=returnService.page(page,pagesize,ROno,goods_id);
        return Rusult.success(pageBean);
    }
}

package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.storage;
import com.database.employee_data.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class StorageController {
    @Autowired
    private StorageService storageService;
    @GetMapping("/storage")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<storage> storageList=storageService.list();
        return Rusult.success(storageList);
    }
    @DeleteMapping("/storage/{saleid}/{goodsid}/{wno}")
    public Rusult delete(@PathVariable String saleid, @PathVariable String goodsid,@PathVariable String wno){
        log.info("删除员工:{},{}",saleid,goodsid,wno);
        storageService.delete(saleid,goodsid,wno);
        return Rusult.success();
    }
    @PostMapping("/storage")
    public Rusult add1(@RequestBody storage storage)
    {
        log.info("新增商品：{}",storage);
        storageService.add(storage);
        return Rusult.success();
    }
    @GetMapping("/storage1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String storageid,String goods_id){
        log.info("分页查询成功");
        PageBean pageBean=storageService.page(page,pagesize,storageid,goods_id);
        return Rusult.success(pageBean);
    }
}

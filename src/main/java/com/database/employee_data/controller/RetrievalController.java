package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.pojo.retrieval;
import com.database.employee_data.service.RetrievalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class RetrievalController {
    @Autowired
    private RetrievalService retrievalService;
    @GetMapping("/retrieval")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<retrieval> retrievalList=retrievalService.list();
        return Rusult.success(retrievalList);
    }
    @DeleteMapping("/retrieval/{retrievalid}/{goodsid}/{wno}")
    public Rusult delete(@PathVariable String retrievalid, @PathVariable String goodsid, @PathVariable String wno){
        log.info("删除员工:{},{}",retrievalid,goodsid,wno);
        retrievalService.delete(retrievalid,goodsid,wno);
        return Rusult.success();
    }
    @PostMapping("/retrieval")
    public Rusult add1(@RequestBody retrieval retrieval)
    {
        log.info("新增商品：{}",retrieval);
        retrievalService.add1(retrieval);
        return Rusult.success();
    }
    @GetMapping("/retrieval1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String retrievalid, String goods_id){
        log.info("分页查询成功");
        PageBean pageBean=retrievalService.page(page,pagesize,retrievalid,goods_id);
        return Rusult.success(pageBean);
    }
}

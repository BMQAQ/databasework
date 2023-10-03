package com.database.employee_data.controller;

import com.database.employee_data.pojo.MoVe;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.goods_sales;
import com.database.employee_data.service.MoVeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class MoVeController {
    @Autowired
    private MoVeService moVeService;
    @GetMapping("/move")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<MoVe> moVeList=moVeService.list();
        return Rusult.success(moVeList);
    }
    @DeleteMapping("/move/{moveid}/{goodsid}/{Win}/{Wout}")
    public Rusult delete(@PathVariable String moveid, @PathVariable String goodsid,@PathVariable String Win,@PathVariable String Wout){
        log.info("删除员工:{},{}",moveid,goodsid,Win,Wout);
        moVeService.delete(moveid,goodsid,Win,Wout);
        return Rusult.success();
    }
    @PostMapping("/move")
    public Rusult add1(@RequestBody MoVe move)
    {
        log.info("新增商品：{}",move);
        moVeService.add(move);
        return Rusult.success();
    }
    @GetMapping("/move1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String moveid, String goods_id,String win,String wout){
        log.info("分页查询成功");
        PageBean pageBean=moVeService.page(page,pagesize,moveid,goods_id,win,wout);
        return Rusult.success(pageBean);
    }
}

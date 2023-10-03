package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.pojo.warehouse;
import com.database.employee_data.service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;
    @GetMapping("/warehouse")
    public Rusult list(){
        log.info("查询全部商品信息");
        List<warehouse> warehouseList=warehouseService.list();
        return Rusult.success(warehouseList);
    }
    @DeleteMapping("/goods_sales/{Wno}")
    public Rusult delete(@PathVariable String Wno){
        log.info("删除员工:{},{}",Wno);
        warehouseService.delete(Wno);
        return Rusult.success();
    }
    @PostMapping("/warehouse")
    public Rusult add(@RequestBody warehouse warehouse)
    {
        log.info("新增部门：{}",warehouse);
        warehouseService.add(warehouse);
        return Rusult.success();
    }
    @GetMapping("/warehouse1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String Wno,String Wphone){
        log.info("分页查询成功");
        PageBean pageBean=warehouseService.page(page,pagesize,Wno,Wphone);
        return Rusult.success(pageBean);
    }
}

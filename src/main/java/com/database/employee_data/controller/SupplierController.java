package com.database.employee_data.controller;

import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.pojo.Supplier;
import com.database.employee_data.pojo.employee;
import com.database.employee_data.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class SupplierController {
    @Autowired
        private SupplierService supplierService;
    @GetMapping("/supplier")
    public Rusult list(){
        log.info("查询全部供应商信息");
        List<Supplier> supplierList=supplierService.list();
        return Rusult.success(supplierList);
    }
    @PostMapping("/supplier")
    public Rusult add(@RequestBody Supplier supplier)
    {
        log.info("新增部门：{}",supplier);
        supplierService.add(supplier);
        return Rusult.success();
    }
    @DeleteMapping("/supplier/{Sno}")
    public Rusult delete(@PathVariable String Sno){
        log.info("根据id删除供应商:{}",Sno);
        supplierService.delete(Sno);
        return Rusult.success();
    }
    @GetMapping("/supplier1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String Sno,String Sname,String Sphone){
        log.info("分页查询成功");
        PageBean pageBean=supplierService.page(page,pagesize,Sno,Sname,Sphone);
        return Rusult.success(pageBean);
    }
    @PostMapping("/supplier/{Sno}/{Sname}/{Sphone}/{Sadress}")
    public  Rusult update(@PathVariable  String Sno,@PathVariable  String Sname,@PathVariable String Sphone,@PathVariable String Sadress){
        log.info("更新员工信息");
        supplierService.update(Sno,Sname,Sphone,Sadress);
        return  Rusult.success();
    }
}

package com.database.employee_data.controller;
import com.database.employee_data.pojo.PageBean;
import com.database.employee_data.pojo.Rusult;
import com.database.employee_data.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.database.employee_data.pojo.employee;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    //private static Logger log= LoggerFactory.getLogger(EmployeeController.class);
    //@RequestMapping(value = "/employee",method = RequestMethod.GET)
    @Autowired
    private EmployeeService empService;
    @GetMapping("/employee")
    public Rusult list(){
            log.info("查询全部员工数据");
            //调用service查询数据
        List<employee> empList=empService.list();
            return Rusult.success(empList);

    }
    @DeleteMapping("/employee/{id}/")
    public Rusult delete(@PathVariable String id){
        log.info("根据id删除员工:{}",id);
        empService.delete(id);
        return Rusult.success();
    }
    @PostMapping("/employee")
    public Rusult add(@RequestBody employee emp)
    {
        log.info("新增部门：{}",emp);
        empService.add(emp);
        return Rusult.success();
    }
    @GetMapping("/employee1")
    public Rusult page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pagesize,
                       String Eno,String name,String sex){
    log.info("分页查询成功");
    PageBean pageBean=empService.page(page,pagesize,Eno,name,sex);
    return Rusult.success(pageBean);
    }
    @GetMapping("/employee/{Eno}")
    public Rusult getById(@PathVariable  String Eno){
            log.info("根据ID查询");
            employee emp=empService.getById(Eno);
            return  Rusult.success(emp);
    }
    @PostMapping("/employee/{Eno}/{Ename}/{Epos}/{Ephone}/{Esex}/{Eid}")
    public  Rusult update(@PathVariable  String Eno,@PathVariable  String Ename,@PathVariable  String Epos,@PathVariable  String Ephone,@PathVariable  String Esex,@PathVariable  String Eid){
            log.info("更新员工信息");
            empService.update(Eno,Ename,Epos,Ephone,Esex,Eid);
            return  Rusult.success();
    }
    @GetMapping("/employee1/{Eno}")
    public Rusult getphoto(@PathVariable  String Eno){
        log.info("根据ID查询");
        String a=empService.getphoto(Eno);
        return  Rusult.success(a);
    }
}

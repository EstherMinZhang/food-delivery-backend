package com.esther.fooddelivery.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.esther.fooddelivery.common.R;
import com.esther.fooddelivery.entity.Employee;
import com.esther.fooddelivery.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee") // mapping frontend to login
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*员工登录处理逻辑如下：
    1、将页面提交的密码password进行md5加密处理
    2、根据页面提交的用户名username查询数据库
    3、如果没有查询到则返回登录失败结果
    4、密码比对，如果不一致则返回登录失败结果
    5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
    6、登录成功，将员工id存入Session并返回登录成功结果*/
    @PostMapping("/login") //用post是因为前端发送的是post方式的请求
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){ //R<Employee> is the return type
        // @RequestBody Employee employee: Spring 会把前端传来的 JSON 自动转换成一个 Employee 对象，然后作为参数传给 login 方法
        //1、将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);//从数据库里查处的一条对象

        //3、如果没有查询到则返回登录失败结果
        if (emp == null) {
            return R.error("Login failed");
        }

        // 4、密码比对，如果不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)) {
            return R.error("Login failed");
        }

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(emp.getStatus() == 0) {
            return R.error("Account has been blocked.");
        }

        //6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }
}

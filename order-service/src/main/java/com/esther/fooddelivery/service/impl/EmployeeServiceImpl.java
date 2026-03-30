package com.esther.fooddelivery.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.esther.fooddelivery.entity.Employee;
import com.esther.fooddelivery.mapper.EmployeeMapper;
import com.esther.fooddelivery.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class
EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}

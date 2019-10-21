package com.selfLearning.oauth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.selfLearning.oauth.dto.Employee;

@RestController
public class EmployeeController {
	
    @RequestMapping(value = "/user/employeeslist",  produces = "application/json")
    @ResponseBody
	 public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        emp.setEmpId("emp1");
        emp.setEmpName("emp1");
        employees.add(emp);
        return employees;

    }


}

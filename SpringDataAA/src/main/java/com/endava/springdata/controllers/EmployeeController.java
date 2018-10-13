package com.endava.springdata.controllers;

import com.endava.springdata.model.Employee;
import com.endava.springdata.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee/add")
    public void addEmployee(@RequestBody Employee employeee) { // Dca nu pun request body imi insereaza null in bd
        service.addEmployee(employeee);
    }
}

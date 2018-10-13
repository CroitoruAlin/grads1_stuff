package com.endava.springdata.services;

import com.endava.springdata.model.Employee;
import com.endava.springdata.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    // Daca am o clasa ce implemeteaza o interfata, spring stie sa faca autowired pe ea
    // Cu Qualified spunem ce clasa vrem sa instantieze daca sunt mai multe ce implementeaza aceeasi interfata pe care
    // Punem noi autowire


    public void addEmployee(Employee employee) {
        if (employeeRepository.findEmployeeByName(employee.getName()) == null) { // Nu e implementata cu optional interfata
            employeeRepository.save(employee);
        }
    }
}

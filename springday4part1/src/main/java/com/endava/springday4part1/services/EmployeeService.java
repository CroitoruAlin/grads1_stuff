package com.endava.springday4part1.services;

import com.endava.springday4part1.model.Employee;
import com.endava.springday4part1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean addEmployee(Employee employee)
    {
        if(employeeRepository.get(employee.getName())==null) {
            employeeRepository.add(employee);
            return true;
        }
        return false;
    }
}

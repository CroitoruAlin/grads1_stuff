package com.endava.springday4part1.repositories;

import com.endava.springday4part1.mappers.EmployeeRowMapper;
import com.endava.springday4part1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EmployeeRowMapper employeeRowMapper;
    public void add(Employee e)
    {
        String sql="insert into employees values(null,?,)";
        jdbcTemplate.update(sql,e.getName());

    }
    public Employee get(String name)
    {
        String sql="select * from employee where name = ?";
        List<Employee> employees=jdbcTemplate.query(sql, employeeRowMapper::mapRow,name);
        return employees.size()>0?employees.get(0):null;
    }

}

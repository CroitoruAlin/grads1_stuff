package com.endava.springdata.repositories;

import com.endava.springdata.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// Tipurile generice pot fi doar generice
// SpringBoot face singur implementarea acestei interfete
// Al doilea parametru este cheia primara(integer)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Iti face maparea intre clasa ta si tabela
    // Si iti genereaza numai operatiile de baza pe acea tabela

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    public Employee findEmployeeByName(@Param("name") String name);// Spring parseaza numele metodei si afla ce vrei sa faci
}

package com.example.JSF.DAO;

import com.example.JSF.Model.Employee;

import java.util.List;

public interface Dao {
    void create(Employee employee);
    Employee  findById(int id);
    List<Employee> findAll();
     void updateEmployee(Employee employee);
    void delete(Employee employee);
    void deleteById(int id);
}

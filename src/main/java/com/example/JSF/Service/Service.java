package com.example.JSF.Service;

import com.example.JSF.DAO.DaoImpl;
import com.example.JSF.Model.Employee;
import com.example.JSF.Util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class Service {
    private DaoImpl employeeDao;


    public Service() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection conn = connectNow.getConnection();
        this.employeeDao = new DaoImpl(conn);
    }
    public Service(DaoImpl employeeDao) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection conn = connectNow.getConnection();
        this.employeeDao = new DaoImpl(conn);
    }




    public void addEmployee(Employee employee) {
        employeeDao.create(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeDao.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public void updateEmployee(Employee employee) {

          employeeDao.updateEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

    public void removeEmployeeById(int id) {
        employeeDao.deleteById(id);
    }

}

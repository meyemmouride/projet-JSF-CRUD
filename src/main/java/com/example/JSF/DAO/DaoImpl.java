package com.example.JSF.DAO;
import com.example.JSF.Model.Employee;
import com.example.JSF.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoImpl implements Dao{
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection conn = connectNow.getConnection();
    public DaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO  user.employe (LastName, FirstName, Email, phoneNumber, Adresse, Department,Salary) VALUES (?, ?, ?, ?, ?, ?,?)";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getLastName());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPhoneNumber());
            pstmt.setString(5, employee.getAdresse());
            pstmt.setString(6, employee.getDepartment());
            pstmt.setString(7, employee.getSalary());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT * FROM user.employe WHERE idEmploye = ?";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("idEmploye"),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("email"),rs.getString("phoneNumber"),rs.getString("address"),rs.getString("department"),rs.getString("salary"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM user.employe";
        try (
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("idEmploye"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getString("phoneNumber"), rs.getString("Adresse"), rs.getString("Department"), rs.getString("Salary")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void delete(Employee employee) {
        String sql = "DELETE FROM user.employe WHERE  idEmploye = ?";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getEmployeeID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM user.employe WHERE  idEmploye = ?";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE user.employe SET  FirstName=?,LastName=?, Email=?, phoneNumber=?, Adresse=?, Department=?, Salary=? WHERE idEmploye=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPhoneNumber());
            pstmt.setString(5, employee.getAdresse());
            pstmt.setString(6, employee.getDepartment());
            pstmt.setString(7, employee.getSalary());
            pstmt.setInt(8, employee.getEmployeeID());

            int updatedRows = pstmt.executeUpdate();
            if (updatedRows > 0) {
                System.out.println("Un employé a été mis à jour avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'employé : " + e.getMessage());
            e.printStackTrace();
        }
    }

}

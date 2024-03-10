package com.example.JSF.Model;

public class Employee {
    private int employeeID;
    private String LastName;
    private String FirstName;
    private String Email;
    private String phoneNumber;
    private String Adresse;
    private String Department;
    private String Salary;

    public Employee() {
    }

    public Employee(String LastName, String FirstName, String email, String phoneNumber, String address, String department ,
                    String salary ) {

        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Email = email;
        this.phoneNumber = phoneNumber;
        this.Adresse= address;
        this.Department = department;
        this.Salary = salary;
    }
    public Employee(int employeeID, String LastName, String FirstName, String email, String phoneNumber, String address, String department ,
                    String salary ) {
        this.Email = email;
        this.employeeID = employeeID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.phoneNumber = phoneNumber;
        this.Adresse= address;
        this.Department = department;
        this.Salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        this.Adresse = adresse;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        this.Department = department;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        this.Salary = salary;
    }
}

package com.example.JSF.Beans;

import com.example.JSF.Model.Employee;
import com.example.JSF.Service.Service;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;

import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeBean {
    private List<Employee> employees;
    private Employee currentEmployee = new Employee();
    private boolean showForm = false;
    private Service employeeService;

    @PostConstruct
    public void init() {
        this.employeeService = new Service();
        loadEmployees();
    }

    private Integer editingId;
    private Employee currentEditingEmployee;

    public boolean isEditing(Integer employeeId) {
        return employeeId != null && employeeId.equals(this.editingId);
    }

    public Integer getEditingId() {
        return editingId;
    }

    public void startEdit(Employee employee) {
        this.currentEditingEmployee = employee;
        this.editingId = employee.getEmployeeID();
    }

    public void loadEmployees() {
        this.employees = employeeService.getAllEmployees();
    }


    public String delete(int id) {
        employeeService.removeEmployeeById(id);
        loadEmployees();
        return null;
    }

    public String save() {
        if (currentEmployee.getEmployeeID() == 0) {
            employeeService.addEmployee(currentEmployee);
        } else {
            employeeService.updateEmployee(currentEmployee);
        }
        loadEmployees();
        cancel();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmation", "Les données sont enregistrées avec succès"));
        return "Employee?faces-redirect=true";
    }

    public String savee() {
        if (currentEditingEmployee != null) {
            employeeService.updateEmployee(currentEditingEmployee);
            loadEmployees();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Les données sont enregistrées avec succès"));
            currentEditingEmployee = null;
        }
        return "Employee?faces-redirect=true";
    }


    public String cancel() {
        this.showForm = false;
        this.currentEmployee = new Employee();
        return null;
    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Service getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(Service employeeService) {
        this.employeeService = employeeService;
    }


}

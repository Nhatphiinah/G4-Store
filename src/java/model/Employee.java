/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Employee {
    private int employeeID;
    private int userID;
    private Date hireDate;
    private double salary;

    public Employee() {}

    public Employee(int employeeID, int userID, Date hireDate, double salary) {
        this.employeeID = employeeID;
        this.userID = userID;
        this.hireDate = hireDate;
        this.salary = salary;
    }
    // Getters and Setters

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}

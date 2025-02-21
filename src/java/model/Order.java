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
public class Order {
    private int orderID;
    private int userID;
    private Date orderDate;
    private double totalAmount;
    private double discountAmount;
    private double finalAmount;
    private String status;
    private String address;
    private String paymentMethod;
    private boolean isActive;

    public Order() {}

    public Order(int orderID, int userID, Date orderDate, double totalAmount, double discountAmount, double finalAmount, String status, String address, String paymentMethod, boolean isActive) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.finalAmount = finalAmount;
        this.status = status;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.isActive = isActive;
    }
    // Getters and Setters

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
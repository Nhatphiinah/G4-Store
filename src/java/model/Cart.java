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
public class Cart {
    private int cartID;
    private int userID;
    private double totalPrice;
    private Date createdAt;

    public Cart() {}

    public Cart(int cartID, int userID, double totalPrice, Date createdAt) {
        this.cartID = cartID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }
    // Getters and Setters

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
}

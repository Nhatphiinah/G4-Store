/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class OrderDetail {
    private int orderDetailID;
    private int orderID;
    private int productID;
    private int variantID;
    private int quantity;
    private double price;
    private double subtotal;

    public OrderDetail() {}

    public OrderDetail(int orderDetailID, int orderID, int productID, int variantID, int quantity, double price, double subtotal) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.variantID = variantID;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }
    // Getters and Setters

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getVariantID() {
        return variantID;
    }

    public void setVariantID(int variantID) {
        this.variantID = variantID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

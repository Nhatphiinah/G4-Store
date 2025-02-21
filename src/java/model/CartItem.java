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
public class CartItem {
    private int cartItemID;
    private int cartID;
    private int productID;
    private int variantID;
    private int quantity;
    private double price;
    private Date createdAt;

    public CartItem() {}

    public CartItem(int cartItemID, int cartID, int productID, int variantID, int quantity, double price, Date createdAt) {
        this.cartItemID = cartItemID;
        this.cartID = cartID;
        this.productID = productID;
        this.variantID = variantID;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }
    // Getters and Setters

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

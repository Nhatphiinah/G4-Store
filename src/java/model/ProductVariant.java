/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class ProductVariant {
    private int variantID;
    private int productID;
    private String size;
    private String color;
    private int stockQuantity;

    public ProductVariant() {}

    public ProductVariant(int variantID, int productID, String size, String color, int stockQuantity) {
        this.variantID = variantID;
        this.productID = productID;
        this.size = size;
        this.color = color;
        this.stockQuantity = stockQuantity;
    }
    // Getters and Setters

    public int getVariantID() {
        return variantID;
    }

    public void setVariantID(int variantID) {
        this.variantID = variantID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
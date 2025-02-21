package model;

import java.util.List;

public class Product {
    private int productID;
    private String productName;
    private int categoryID;
    private int brandID;
    private double price;
    private String description;
    private String imageURL;
    private boolean status;
    private List<ProductVariant> variants;

    public Product() {}

    public Product(int productID, String productName, int categoryID, int brandID, double price, String description, String imageURL, boolean status, List<ProductVariant> variants) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.brandID = brandID;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.status = status;
        this.variants = variants;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<ProductVariant> variants) {
        this.variants = variants;
    }
}
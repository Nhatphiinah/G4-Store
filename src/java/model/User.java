package model;

import java.util.Date;
import java.util.List;

// User.java
public class User {
    private int userID;
    private String username;
    private String password;
    private boolean status;
    private String address;
    private String phone;
    private String email;
    private String fullName;
    private String role;

    public User() {}

    public User(int userID, String username, String password, boolean status, String address, String phone, String email, String fullName, String role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.status = status;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
    }
    // Getters and Setters

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
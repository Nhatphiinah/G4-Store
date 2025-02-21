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
    public class Admin {
    private int adminID;
    private int userID;

    public Admin() {}

    public Admin(int adminID, int userID) {
        this.adminID = adminID;
        this.userID = userID;
    }
    // Getters and Setters

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

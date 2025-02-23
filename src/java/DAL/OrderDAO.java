/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author ASUS
 */

import context.DBcontext;
import model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class OrderDAO {
    
    // Lấy danh sách tất cả các đơn hàng (Chỉ lấy những đơn hàng còn hoạt động)
    public List<Order> getAllOrders() {
       List<Order> orders = new ArrayList<Order>();

        String query = "SELECT * FROM Orders WHERE IsActive = 1";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                orders.add(new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("UserID"),
                    rs.getTimestamp("OrderDate"),
                    rs.getBigDecimal("TotalAmount"),
                    rs.getBigDecimal("DiscountAmount"),
                    rs.getBigDecimal("FinalAmount"),
                    rs.getString("Status"),
                    rs.getString("Address"),
                    rs.getString("PaymentMethod"),
                    rs.getBoolean("IsActive")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Lấy đơn hàng theo ID
    public Order getOrderById(int orderId) {
        String query = "SELECT * FROM Orders WHERE OrderID = ? AND IsActive = 1";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("UserID"),
                    rs.getTimestamp("OrderDate"),
                    rs.getBigDecimal("TotalAmount"),
                    rs.getBigDecimal("DiscountAmount"),
                    rs.getBigDecimal("FinalAmount"),
                    rs.getString("Status"),
                    rs.getString("Address"),
                    rs.getString("PaymentMethod"),
                    rs.getBoolean("IsActive")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm mới đơn hàng
   public void insertOrder(Order order) {
    String query = "INSERT INTO Orders (UserID, OrderDate, TotalAmount, DiscountAmount, FinalAmount, Status, Address, PaymentMethod, IsActive) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)";

    try (Connection conn = new DBcontext().getConnection();
         PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        
        ps.setInt(1, order.getUserID());
        ps.setTimestamp(2, order.getOrderDate());
        ps.setBigDecimal(3, order.getTotalAmount());
        ps.setBigDecimal(4, order.getDiscountAmount());
        ps.setBigDecimal(5, order.getFinalAmount());
        ps.setString(6, order.getStatus());
        ps.setString(7, order.getAddress());
        ps.setString(8, order.getPaymentMethod());

        int affectedRows = ps.executeUpdate();

        if (affectedRows > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                order.setOrderID(rs.getInt(1));
                System.out.println("✅ Đơn hàng đã được thêm với ID: " + order.getOrderID());
            }
        } else {
            System.out.println("❌ Không thể thêm đơn hàng!");
        }

    } catch (SQLException e) {
        System.out.println("❌ Lỗi SQL khi thêm đơn hàng!");
        e.printStackTrace();
    }
}



    // Cập nhật đơn hàng
    public void updateOrder(Order order) {
        String query = "UPDATE Orders SET UserID = ?, OrderDate = ?, TotalAmount = ?, DiscountAmount = ?, FinalAmount = ?, Status = ?, Address = ?, PaymentMethod = ? " +
                       "WHERE OrderID = ?";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, order.getUserID());
            ps.setTimestamp(2, order.getOrderDate());
            ps.setBigDecimal(3, order.getTotalAmount());
            ps.setBigDecimal(4, order.getDiscountAmount());
            ps.setBigDecimal(5, order.getFinalAmount());
            ps.setString(6, order.getStatus());
            ps.setString(7, order.getAddress());
            ps.setString(8, order.getPaymentMethod());
            ps.setInt(9, order.getOrderID());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa mềm đơn hàng (Chuyển trạng thái IsActive = 0)
    public void deleteOrder(int orderId) {
        String query = "UPDATE Orders SET IsActive = 0 WHERE OrderID = ?";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

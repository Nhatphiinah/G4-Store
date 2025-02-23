/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;



import context.DBcontext;
import model.OrderDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class OrderDetailDAO {

    // Lấy danh sách chi tiết đơn hàng theo OrderID
public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
    List<OrderDetail> details = new ArrayList<OrderDetail>();
    String query = "SELECT * FROM OrderDetails WHERE OrderID = ?";

    try (Connection conn = new DBcontext().getConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setInt(1, orderId);
        System.out.println("📌 Đang lấy chi tiết đơn hàng cho OrderID: " + orderId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            OrderDetail detail = new OrderDetail(
                rs.getInt("OrderDetailID"),
                rs.getInt("OrderID"),
                rs.getInt("ProductID"),
                rs.getInt("VariantID"),
                rs.getInt("Quantity"),
                rs.getBigDecimal("Price"),
                rs.getBigDecimal("Subtotal")
            );
            details.add(detail);
            System.out.println("✅ Tìm thấy chi tiết đơn hàng: " + detail.getOrderDetailID());
        }

        if (details.isEmpty()) {
            System.out.println("❌ Không có sản phẩm nào trong đơn hàng " + orderId);
        }

    } catch (SQLException e) {
        System.out.println("❌ Lỗi SQL khi lấy chi tiết đơn hàng!");
        e.printStackTrace();
    }

    return details;
}


    // Lấy chi tiết đơn hàng theo OrderDetailID
    public OrderDetail getOrderDetailById(int orderDetailId) {
        String query = "SELECT * FROM OrderDetails WHERE OrderDetailID = ?";
        
        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, orderDetailId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new OrderDetail(
                    rs.getInt("OrderDetailID"),
                    rs.getInt("OrderID"),
                    rs.getInt("ProductID"),
                    rs.getInt("VariantID"),
                    rs.getInt("Quantity"),
                    rs.getBigDecimal("Price"),
                    rs.getBigDecimal("Subtotal")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm mới chi tiết đơn hàng
 public void insertOrderDetail(OrderDetail detail) {
    String query = "INSERT INTO OrderDetails (OrderID, ProductID, VariantID, Quantity, Price, Subtotal) " +
                   "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = new DBcontext().getConnection();
         PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        ps.setInt(1, detail.getOrderID());
        ps.setInt(2, detail.getProductID());
        ps.setObject(3, detail.getVariantID() == 0 ? null : detail.getVariantID(), java.sql.Types.INTEGER);
        ps.setInt(4, detail.getQuantity());
        ps.setBigDecimal(5, detail.getPrice());
        ps.setBigDecimal(6, detail.getSubtotal());

        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                detail.setOrderDetailID(rs.getInt(1));
                System.out.println("✅ Đã thêm chi tiết đơn hàng với ID: " + detail.getOrderDetailID());
            }
        } else {
            System.out.println("❌ Không thể thêm chi tiết đơn hàng!");
        }
    } catch (Exception e) {
        System.out.println("❌ Lỗi SQL khi thêm chi tiết đơn hàng!");
        e.printStackTrace();
    }
}



    // Cập nhật chi tiết đơn hàng
    public void updateOrderDetail(OrderDetail detail) {
        String query = "UPDATE OrderDetails SET OrderID = ?, ProductID = ?, VariantID = ?, Quantity = ?, Price = ?, Subtotal = ? " +
                       "WHERE OrderDetailID = ?";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, detail.getOrderID());
            ps.setInt(2, detail.getProductID());
            ps.setInt(3, detail.getVariantID());
            ps.setInt(4, detail.getQuantity());
            ps.setBigDecimal(5, detail.getPrice());
            ps.setBigDecimal(6, detail.getSubtotal());
            ps.setInt(7, detail.getOrderDetailID());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa chi tiết đơn hàng
    public void deleteOrderDetail(int orderDetailId) {
        String query = "DELETE FROM OrderDetails WHERE OrderDetailID = ?";

        try (Connection conn = new DBcontext().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, orderDetailId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

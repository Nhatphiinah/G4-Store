<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.OrderDetail, DAL.OrderDetailDAO" %>

<%
    // Khởi tạo OrderDetailDAO trực tiếp thay vì dùng <jsp:useBean>
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    // Xử lý lỗi nếu orderId không được truyền vào URL
    String orderIdParam = request.getParameter("orderId");
    int orderId = 0;
    List<OrderDetail> orderDetails = null;

    if (orderIdParam != null) {
        try {
            orderId = Integer.parseInt(orderIdParam);
            orderDetails = orderDetailDAO.getOrderDetailsByOrderId(orderId);
        } catch (NumberFormatException e) {
            orderId = 0;
        }
    }

    if (orderId == 0) {
%>
        <h2>Lỗi: Không tìm thấy đơn hàng!</h2>
        <a href="order-list.jsp">Quay lại danh sách đơn hàng</a>
<%
        return; // Dừng trang nếu không có orderId hợp lệ
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đơn hàng</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            display: inline-block;
            padding: 8px 15px;
            margin: 10px;
            font-size: 14px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .delete-btn {
            background-color: #dc3545;
        }
        .delete-btn:hover {
            background-color: #b52b3a;
        }
    </style>
</head>
<body>

    <h2>Chi tiết Đơn Hàng #<%= orderId %></h2>
    <a href="order-detail-form.jsp?orderId=<%= orderId %>" class="btn">Thêm sản phẩm</a>
    <a href="order-list.jsp" class="btn">Quay lại danh sách đơn hàng</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Mã Sản Phẩm</th>
            <th>Mã Biến Thể</th>
            <th>Số Lượng</th>
            <th>Giá</th>
            <th>Thành Tiền</th>
            <th>Hành động</th>
        </tr>
        <% if (orderDetails != null && !orderDetails.isEmpty()) { %>
            <% for (OrderDetail detail : orderDetails) { %>
                <tr>
                    <td><%= detail.getOrderDetailID() %></td>
                    <td><%= detail.getProductID() %></td>
                    <td><%= detail.getVariantID() %></td>
                    <td><%= detail.getQuantity() %></td>
                    <td><%= detail.getPrice() %></td>
                    <td><%= detail.getSubtotal() %></td>
                    <td>
                        <a href="order-detail-form.jsp?orderDetailId=<%= detail.getOrderDetailID() %>&orderId=<%= orderId %>" class="btn">Sửa</a>
                        <a href="order-detail?action=delete&orderDetailId=<%= detail.getOrderDetailID() %>&orderId=<%= orderId %>" class="btn delete-btn" onclick="return confirm('Xóa chi tiết đơn hàng này?');">Xóa</a>
                    </td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="7">Không có sản phẩm nào trong đơn hàng này.</td>
            </tr>
        <% } %>
    </table>

</body>
</html>

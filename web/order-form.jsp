<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Order, DAL.OrderDAO" %> <%-- Đảm bảo đúng package --%>

<%
    // Khởi tạo OrderDAO trực tiếp thay vì dùng <jsp:useBean>
    OrderDAO orderDAO = new OrderDAO();

    String action = "create";
    Order order = null;
    String orderIdParam = request.getParameter("orderId");

    if (orderIdParam != null) {
        int orderId = Integer.parseInt(orderIdParam);
        order = orderDAO.getOrderById(orderId);
        action = "update";
    }
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title><%= (order != null ? "Chỉnh sửa Đơn Hàng" : "Thêm Đơn Hàng") %></title>
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
        form {
            display: inline-block;
            text-align: left;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            background: #f9f9f9;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
        }
        .btn {
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .cancel-btn {
            background-color: #6c757d;
            text-decoration: none;
            display: inline-block;
            padding: 10px 15px;
            color: white;
            border-radius: 5px;
        }
        .cancel-btn:hover {
            background-color: #545b62;
        }
    </style>
</head>
<body>

    <h2><%= (order != null ? "Chỉnh sửa Đơn Hàng" : "Thêm Đơn Hàng") %></h2>
    
    <form action="order" method="post">
        <input type="hidden" name="action" value="<%= action %>">
        <% if (order != null) { %>
            <input type="hidden" name="orderId" value="<%= order.getOrderID() %>">
        <% } %>

        <label for="userId">ID Người dùng:</label>
        <input type="number" name="userId" value="<%= (order != null ? order.getUserID() : "") %>" required>

        <label for="status">Trạng thái:</label>
        <select name="status">
            <option value="Pending" <%= (order != null && order.getStatus().equals("Pending") ? "selected" : "") %>>Chờ xử lý</option>
            <option value="Completed" <%= (order != null && order.getStatus().equals("Completed") ? "selected" : "") %>>Hoàn thành</option>
            <option value="Cancelled" <%= (order != null && order.getStatus().equals("Cancelled") ? "selected" : "") %>>Hủy bỏ</option>
        </select>

        <label for="address">Địa chỉ:</label>
        <input type="text" name="address" value="<%= (order != null ? order.getAddress() : "") %>" required>

        <label for="paymentMethod">Phương thức thanh toán:</label>
        <select name="paymentMethod">
            <option value="CASH" <%= (order != null && order.getPaymentMethod().equals("CASH") ? "selected" : "") %>>Tiền mặt</option>
            <option value="CREDIT_CARD" <%= (order != null && order.getPaymentMethod().equals("CREDIT_CARD") ? "selected" : "") %>>Thẻ tín dụng</option>
            <option value="PAYPAL" <%= (order != null && order.getPaymentMethod().equals("PAYPAL") ? "selected" : "") %>>PayPal</option>
            <option value="BANK_TRANSFER" <%= (order != null && order.getPaymentMethod().equals("BANK_TRANSFER") ? "selected" : "") %>>Chuyển khoản ngân hàng</option>
        </select>

        <input type="submit" class="btn" value="<%= (order != null ? "Cập nhật" : "Thêm") %>">
        <a href="order-list.jsp" class="cancel-btn">Hủy</a>
    </form>

</body>
</html>

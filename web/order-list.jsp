<%@ page import="DAL.OrderDAO, model.Order, java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    OrderDAO orderDAO = new OrderDAO();
    List<Order> orders = orderDAO.getAllOrders();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách đơn hàng</title>
</head>
<body>
    <h2>Danh sách Đơn Hàng</h2>
    <a href="order-form.jsp">Thêm Đơn Hàng</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Người dùng</th>
            <th>Ngày đặt</th>
            <th>Tổng tiền</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <% for (Order order : orders) { %>
        <tr>
            <td><%= order.getOrderID() %></td>
            <td><%= order.getUserID() %></td>
            <td><%= order.getOrderDate() %></td>
            <td><%= order.getFinalAmount() %></td>
            <td><%= order.getStatus() %></td>
            <td>
                <a href="order?action=edit&orderId=<%= order.getOrderID() %>">Sửa</a>
                <a href="order?action=delete&orderId=<%= order.getOrderID() %>" onclick="return confirm('Xóa đơn hàng này?');">Xóa</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>

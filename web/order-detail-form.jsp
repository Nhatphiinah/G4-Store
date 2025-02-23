<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.OrderDetail, DAL.OrderDetailDAO" %>

<%
    int orderId = Integer.parseInt(request.getParameter("orderId"));
    String orderDetailIdParam = request.getParameter("orderDetailId");
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    OrderDetail detail = null;
    String action = "create";

    if (orderDetailIdParam != null) {
        int orderDetailId = Integer.parseInt(orderDetailIdParam);
        detail = orderDetailDAO.getOrderDetailById(orderDetailId);
        action = "update";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title><%= (detail != null ? "Chỉnh sửa Chi Tiết Đơn Hàng" : "Thêm Chi Tiết Đơn Hàng") %></title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h2><%= (detail != null ? "Chỉnh sửa Chi Tiết Đơn Hàng" : "Thêm Chi Tiết Đơn Hàng") %></h2>
    
    <form action="order-detail" method="post">
        <input type="hidden" name="action" value="<%= action %>">
        <input type="hidden" name="orderId" value="<%= orderId %>">
        <% if (detail != null) { %>
            <input type="hidden" name="orderDetailId" value="<%= detail.getOrderDetailID() %>">
        <% } %>

        <label for="productId">Mã Sản Phẩm:</label>
        <input type="number" name="productId" value="<%= (detail != null ? detail.getProductID() : "") %>" required><br>

        <label for="variantId">Mã Biến Thể:</label>
        <input type="number" name="variantId" value="<%= (detail != null ? detail.getVariantID() : "") %>"><br>

        <label for="quantity">Số Lượng:</label>
        <input type="number" name="quantity" value="<%= (detail != null ? detail.getQuantity() : "") %>" required><br>

        <label for="price">Giá:</label>
        <input type="number" step="0.01" name="price" value="<%= (detail != null ? detail.getPrice() : "") %>" required><br>

        <input type="submit" value="<%= (detail != null ? "Cập nhật" : "Thêm") %>">
        <a href="order-detail-list.jsp?orderId=<%= orderId %>">Hủy</a>
    </form>
</body>
</html>

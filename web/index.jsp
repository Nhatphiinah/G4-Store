<%-- 
    Document   : index
    Created on : Feb 21, 2025, 11:59:33 PM
    Author     : ASUS
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang Quản Lý Đơn Hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        h1 {
            color: #333;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h1>Quản Lý Đơn Hàng</h1>

    <a href="order-list.jsp" class="btn">Danh Sách Đơn Hàng</a>
    <a href="order-form.jsp" class="btn">Thêm Đơn Hàng</a>
    <a href="order-detail-list.jsp?orderId=1" class="btn">Chi Tiết Đơn Hàng</a> <!-- orderId=1 chỉ là ví dụ -->
    <a href="order-detail-form.jsp?orderId=1" class="btn">Thêm Chi Tiết Đơn Hàng</a>

</body>
</html>

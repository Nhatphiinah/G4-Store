<%-- 
    Document   : UpdateProfile
    Created on : Feb 24, 2025, 1:33:20 AM
    Author     : Nguyen Dinh Quoc - CE181874
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.User" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    // Lấy thông tin user từ session
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile - G4 Store</title>
    <link rel="stylesheet" href="UpdateProfile.css">
</head>
<body>
    <div class="profile-container">
        <h2>Update Profile</h2>
        
        <form action="UpdateProfile" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" value="<%= user.getFullName() %>" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= user.getEmail() %>" required>

            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="<%= user.getPhone() %>" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="<%= user.getAddress() %>" required>

            <button type="submit">Update</button>
        </form>

        <!-- Hiển thị thông báo -->
        <% String message = request.getParameter("message"); %>
        <% if (message != null) { %>
            <p class="success-message"><%= message %></p>
        <% } %>
        
        <p><a href="Login">Back to Home</a></p>
    </div>
</body>
</html>

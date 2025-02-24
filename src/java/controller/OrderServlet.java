package controller;

import DAL.OrderDAO;
import model.Order;
import java.io.IOException;
import java.sql.Timestamp;
import java.math.BigDecimal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderDAO orderDAO = new OrderDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "delete":
                    int orderId = Integer.parseInt(request.getParameter("orderId"));
                    orderDAO.deleteOrder(orderId);
                    response.sendRedirect("order-list.jsp");
                    return;
                case "edit":
                    orderId = Integer.parseInt(request.getParameter("orderId"));
                    Order order = orderDAO.getOrderById(orderId);
                    request.setAttribute("order", order);
                    request.getRequestDispatcher("order-form.jsp").forward(request, response);
                    return;
            }
        }

        request.setAttribute("orders", orderDAO.getAllOrders());
        request.getRequestDispatcher("order-list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    if ("create".equals(action)) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String status = request.getParameter("status");
        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");

        // Kiểm tra giá trị đầu vào
        System.out.println("🔹 Đang thêm đơn hàng mới:");
        System.out.println("UserID: " + userId);
        System.out.println("Status: " + status);
        System.out.println("Address: " + address);
        System.out.println("PaymentMethod: " + paymentMethod);

        Order order = new Order(0, userId, new Timestamp(System.currentTimeMillis()), 
                new BigDecimal("100.00"), new BigDecimal("0.00"), new BigDecimal("100.00"), 
                status, address, paymentMethod, true);

        orderDAO.insertOrder(order);
    }

    response.sendRedirect("order-list.jsp");
}
}

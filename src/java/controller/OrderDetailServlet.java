package controller;

import DAL.OrderDetailDAO;
import model.OrderDetail;
import java.io.IOException;
import java.math.BigDecimal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/order-detail")
public class OrderDetailServlet extends HttpServlet {

    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    if ("create".equals(action)) {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            int variantId = request.getParameter("variantId") != null ? Integer.parseInt(request.getParameter("variantId")) : 0;
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            BigDecimal subtotal = price.multiply(new BigDecimal(quantity));

            OrderDetail detail = new OrderDetail(0, orderId, productId, variantId, quantity, price, subtotal);
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            orderDetailDAO.insertOrderDetail(detail);

            System.out.println("✅ Đã gọi insertOrderDetail() cho OrderID: " + orderId);

            response.sendRedirect("order-detail-list.jsp?orderId=" + orderId);
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi thêm chi tiết đơn hàng!");
            e.printStackTrace();
            request.setAttribute("error", "Lỗi khi thêm chi tiết đơn hàng!");
            request.getRequestDispatcher("order-detail-form.jsp").forward(request, response);
        }
    }
  }
}

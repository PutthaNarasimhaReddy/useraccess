package useraccessmanagementsss.servlets;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action");
        String status = action.equals("approve") ? "Approved" : "Rejected";

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_access_db", "postgres", "123456789")) {
            String sql = "UPDATE requests SET status = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, requestId);
            stmt.executeUpdate();
            response.sendRedirect("pendingRequests.jsp?status=updated");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Failed to update request status.");
        }
    }
}

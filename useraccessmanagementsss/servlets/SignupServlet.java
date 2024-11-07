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

	
	public class SignupServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String role = "Employee";  // Default role

	        try (Connection conn =DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_access_db", "postgres", "123456789")) {
	            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            stmt.setString(3, role);
	            stmt.executeUpdate();
	            response.sendRedirect("login.jsp");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.getWriter().write("Registration failed. Try again.");
	        }
	    }
	}

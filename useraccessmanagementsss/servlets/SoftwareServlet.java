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


public class SoftwareServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    String name = request.getParameter("name");
		    String description = request.getParameter("description");
		    String accessLevels = request.getParameter("accessLevels");

		    try (Connection conn = DriverManager. getConnection("jdbc:postgresql://localhost:5432/user_access_db", "postgres", "123456789")){
		      PreparedStatement stmt = conn.prepareStatement("INSERT INTO software (name, description, access_levels) VALUES (?, ?, ?)");
		      stmt.setString(1, name);
		      stmt.setString(2, description);
		      stmt.setString(3, accessLevels);
		      stmt.executeUpdate();

		      response.sendRedirect("createSoftware.jsp");
		    } catch (SQLException e) {
		      throw new ServletException(e);
		    }
		  }

}

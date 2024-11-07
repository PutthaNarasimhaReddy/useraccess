package useraccessmanagementsss.servlets;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RequestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    String username = request.getParameter("username");
		    String softwareName = request.getParameter("softwareName");
		    String accessType = request.getParameter("accessType");
		    String reason = request.getParameter("reason");

		    int softwareId = getSoftwareId(softwareName);

		    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user_access_db", "postgres", "123456789")) {
		      PreparedStatement stmt = conn.prepareStatement("INSERT INTO requests (user_id, software_id, access_type, reason, status) VALUES ((SELECT id FROM users WHERE username = ?), ?, ?, ?, 'Pending')");
		      stmt.setString(1, username);
		      stmt.setInt(2, softwareId);
		      stmt.setString(3, accessType);
		      stmt.setString(4, reason);
		      stmt.executeUpdate();

		      response.sendRedirect("requestAccess.jsp");
		    } catch (SQLException e) {
		      throw new ServletException(e);
		    }
		  }

		  private int getSoftwareId(String softwareName) throws ServletException {
		    int softwareId = 0;
		    try (Connection conn = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/user_access_db", "postgres", "123456789")) {
		      PreparedStatement stmt = conn.prepareStatement("SELECT id FROM software WHERE name = ?");
		      stmt.setString(1, softwareName);
		      ResultSet rs = stmt.executeQuery();
		      if (rs.next()) {
		        softwareId = rs.getInt("id");
		      }
		    } catch (SQLException e) {
		      throw new ServletException(e);
		    }
		    return softwareId;
		  }
		}




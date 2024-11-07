<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
<h1>Request Access</h1>
  <form action="RequestServlet" method="post">
    <label>Software Name:</label>
    
    <select name="softwareName">
      <c:forEach items="${softwareNames}" var="softwareName">
        <option value="${softwareName}">${softwareName}</option>
      </c:forEach>
    </select><br>
    
    <label>Access Type:</label>
    <select name="accessType">
      <option value="Read">Read</option>
      <option value="Write">Write</option>
      <option value="Admin">Admin</option>
    </select><br>
    <label>Reason:</label>
    <textarea name="reason"></textarea><br>
    <input type="submit" value="Request Access">
  </form>


</body>
</html>
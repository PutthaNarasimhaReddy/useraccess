<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Create New Software</h2>
    <form action="SoftwareServlet" method="post">
        Software Name: <input type="text" name="name"><br>
        Description: <textarea name="description"></textarea><br>
        Access Levels (comma-separated): <select name="accessType">
      <option value="Read">Read</option>
      <option value="Write">Write</option>
      <option value="Admin">Admin</option>
    </select><br><br>
        <input type="submit" value="Add Software">
    </form>
</body>
</html>
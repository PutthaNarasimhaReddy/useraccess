<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Sign Up</h2>
    <form action="SignupServlet" method="post">
        UserName: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="hidden" name="role" value="Employee">
        <input type="submit" value="Register">
    </form>
</body>
</html>
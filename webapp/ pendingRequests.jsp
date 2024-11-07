<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Pending Access Requests</h2>
    <c:forEach var="request" items="${requests}">
        <div>
            <p>User ID: ${request.userId}</p>
            <p>Software ID: ${request.softwareId}</p>
            <p>Access Type: ${request.accessType}</p>
            <p>Reason: ${request.reason}</p>
            <form action="ApprovalServlet" method="post">
                <input type="hidden" name="requestId" value="${request.id}">
                <button type="submit" name="action" value="approve">Approve</button>
                <button type="submit" name="action" value="reject">Reject</button>
            </form>
        </div>
    </c:forEach>
</body>
</html>
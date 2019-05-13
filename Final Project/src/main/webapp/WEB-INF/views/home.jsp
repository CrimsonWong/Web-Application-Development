<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome!
</h1>
	<a href="${pageContext.request.contextPath}/viewMyMessages">View My Messages</a>
	<br>
	<a href="${pageContext.request.contextPath}/viewAllMessages">View All Messages</a>
	<br>
	<a href="${pageContext.request.contextPath}/sendMessage">Send Message</a>	
	<br>
</body>
</html>

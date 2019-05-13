<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send New Message</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/send" method="post"
		modelAttribute="Message">
		
	<h3>Please enter your message: </h3>
	<form:input type="text" path="message" required="required" />
	<input type="submit" value="Send Message" />

	</form:form>
	
	<a href="${pageContext.request.contextPath}/backhome">Back Home</a>
	
</body>
</html>

<!-- <textarea id="address" name="address" rows="5" cols="30"> </textarea><br><br> -->


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="com.me.pojo.Message"%>
<%@page import="java.util.List"%>
<!DOCTYPE htm 
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message View</title>
    </head>
    <body>
        <h1>View All Messages:</h1>
                
        <c:forEach var="m" items="${messages}">
        <c:out value="${m.getUser().getUsername()}"/>
        <c:out value="m"/>
        	<br>
        </c:forEach>
        
        <a href="${pageContext.request.contextPath}/backhome">Back Home</a>
        
    </body>

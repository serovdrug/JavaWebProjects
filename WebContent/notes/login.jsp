<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Notes | Login</title>
</head>
<body>
<form method="post">
	<H1>Hello, who are you?</H1>
	<label for="username">Name:</label>
	
	<c:choose>
	    <c:when test="${empty users}">
	         <input id="username" name="username" autofocus placeholder="username">
	    </c:when>
	    <c:otherwise>
	        <select id="username" name="username">
		  <c:forEach items="${users}" var="item">
		    <option>
		          ${item}
		    </option>
		  </c:forEach>
	 	</select>
	    </c:otherwise>
	</c:choose>
	<input type="submit" value="Enter">
</form>

 
</body>
</html>
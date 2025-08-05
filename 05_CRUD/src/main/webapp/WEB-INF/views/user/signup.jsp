<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

  <h1>SignUp</h1>
  
  <form method="post"
        action="${contextPath}/user/signup">
  
    <label>email : <input type="text" name="email"></label>
    <span id="email-msg"></span>
    <br>
    
    <label>password : <input type="password" name="password"></label>
    <br>
    
    <label>nickname : <input type="text" name="nickname"></label>
    <span id="nickname-msg"></span>
    <br>
    
    <button type="submit">signup</button>
            
  </form>
  
  <c:if test="${not empty error }">
    <div style="font-size: 12px; color: red;">${error}</div>
  </c:if>
  
  
</body>
</html>
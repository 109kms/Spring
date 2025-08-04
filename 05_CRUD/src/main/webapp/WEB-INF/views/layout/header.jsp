<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>${param.title}</title>
<script type="text/javascript">
  const msg = "${msg}";
  if (msg !== "") alert(msg);
  function loginForm() {
    location.href = `${contextPath}/user/login?url=\${location.href}`;  //----- 현재 페이지의 주소(url)를 전달하면 로그인 성공 후 현재 페이지로 되돌아 올 수 있습니다.
  }
</script>
</head>
<body>

  <h1>Hello World</h1>

  <c:if test="${empty sessionScope.nickname}">
    <div>
      <a href="javascript:loginForm()"><i class="fa-solid fa-arrow-right-from-bracket"></i>로긴</a>
    </div>  
  </c:if>
  
  <c:if test="${not empty sessionScope.nickname}">
    <div>
      <a href="${contextPath}/user/myinfo">${sessionScope.nickname}</a>님 반가워요.
      <a href="${contextPath}/user/logout">로가웃</a>
    </div>
  </c:if>

  <nav>
    <ul style="display: flex; list-style: none;">
      <li><a href="${contextPath}/board/list">게시판</a></li>
      <li><a href="${contextPath}/board/list">게시판</a></li>
      <li><a href="${contextPath}/board/list">게시판</a></li>
      <li><a href="${contextPath}/board/list">게시판</a></li>
      <li><a href="${contextPath}/board/list">게시판</a></li>
    </ul>        
  </nav>
  
  <hr>
  

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
  
  <h1>User Info Upload</h1>
  <form method="post"
        action="${contextPath}/user/signup"
        enctype="multipart/form-data"
        id="signupForm">
    <label>email : <input type="text" name="email"></label>
    <br>
    <input type="file" name="profile" id="profile">
    <br>
    <button type="submit">가입</button>        
  </form>
  <c:if test="${not empty error}">
    <div style="font-size: 12px; color: red;">${error}</div>
  </c:if>
  
  <script type="text/javascript">
  	const signupForm = document.getElementById("signupForm");
  	const profile = document.getElementById("profile");
  	signupForm.addEventListener("submit", function(e) {
  	  //----- 첨부된 파일
  	  const file = profile.files[0];
  	  if (file) {
  	    const limit = 1024 * 1024 * 10; //----- 10MB
  	    if (file.size > limit) {
  	      alert('파일이 너무 커요;;');
  	      file.value = "";  //----- 첨부된 파일 초기화
  	      e.preventDefault();  //-- 서브밋 방지
  	      return;
  	    }
  	  }
  	})
  </script>
  
  <hr>
  
  <h1>User List</h1>
  <table border="1">
    <tbody>
      <c:forEach items="${users}" var="user">
        <tr>
          <td><a href="${contextPath}/user/detail?uid=${user.uid}">${user.email}</a></td>
          <td>${user.originalFilename}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

</body>
</html>
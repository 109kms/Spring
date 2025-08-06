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
  
  <h1>Write Notice</h1>
  <form method="post"
        action="${contextPath}/notice/signup"
        enctype="multipart/form-data"
        id="writeForm">
    <label>title : <input type="text" name="title"></label>
    <br>
    <textarea name="content"></textarea>
    <br>
    <input type="file" name="files" id="files" multiple>
    <br>
    <button type="submit">작성하기</button>        
  </form>
  
  <script type="text/javascript">
  	const files = document.getElementById("files");  //----- files DOM 객체
    const limitPerFile = 1024 * 1024;
  	const limitTotal = 1024 * 1024;
  	files.addEventListener("change", function(e) {
  	  //----- 첨부된 파일  
  	  for (const file of files.files) {  //------------------------- files DOM 객체의 files 프로퍼티
  	  	
  	  }
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
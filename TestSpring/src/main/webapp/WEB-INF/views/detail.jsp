<%@page import="com.spring.dto.TempDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://github.com/JosephBean/SpringStudy2/blob/main/src/main/webapp/resources/images/logo.png?raw=true" rel="icon" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>DETAIL</title>
</head>
<body>
<%
	Object obj1 = request.getAttribute("list");
	TempDTO dto = (TempDTO)obj1;
		
%>
    <div class="container mt-3">
        <h1 class="text-center bg-success text-dark bg-opacity-50">DETAIL</h1>
        <form action="./edit" method="post">
            <div class="mb-3 mt-3">
			  <input type="hidden" class="form-control" id="no" name="no" value='<%=dto.getNo()%>'> <!-- java에서 만 사용하기 때문에 화면에 노출하지 않는다.  -->
              <label for="title" class="form-label">Title:</label>
              <input type="text" class="form-control" id="title" placeholder="Enter title" name="title"  value ='<%=dto.getTitle()%>' required autocomplete="off">
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">Content:</label>
              <input type="text" class="form-control" id="content" placeholder="Enter content" name="content" value='<%=dto.getContent()%>' autocomplete="off">
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2" type="submit">수정</button>
                <a class="btn btn-success" href="./accept?no=<%=dto.getNo()%>&accept=true">승인</a>
                <a class="btn btn-warning" href="./accept?no=<%=dto.getNo()%>&accpet=false">미승인</a>
                <a class="btn btn-secondary" href="./list">취소</a>
  
            </div>
        </form>
    </div>
</body>
</html>
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
    <title>LIST</title>
    <style>
        a.list-group-item:hover {cursor: pointer;font-weight:bold;color:#fff;background-color:#b2327d;box-shadow:5px 5px 10px 5px rgba(77, 71, 71, 0.2);}
    </style>
</head>
<body>
<%
	Object obj1 = request.getAttribute("list");
	List<TempDTO> list = null;
	if(obj1 !=null){
		list = (List<TempDTO>)obj1;
	}
	
%>
    <div class="container mt-3">
        <h1 class="text-center bg-success text-dark bg-opacity-50">LIST</h1>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <a href="./list" class="btn btn-secondary">전체</a>
            <a href="./list?accept=true" class="btn btn-success">승인</a>
            <a href="./list?accept=false" class="btn btn-warning">미승인</a>
            <a href="./new" class="btn btn-primary">추가</a>
        </div>
        <div class="list-group mt-2 text-center">
<% 
	for(TempDTO dto : list) {
		if(dto.isAccept()){
%>        
            <a class="list-group-item m-1 bg-success display-6" href="./detail?no=<%=dto.getNo()%>">
                <%=dto.getTitle() %>
            </a>        
<%
		} else {
%>
            <a class="list-group-item m-1 bg-warning display-6" href="./detail?no=<%=dto.getNo()%>">
                <%=dto.getTitle() %>    
            </a> 
<%		
		}
	}
%>
        </div>
    </div>
</body>
</html>
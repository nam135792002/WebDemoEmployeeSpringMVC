<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Page</title>
		<link rel="stylesheet" type="text/css" href="/SpringMVCExample/URLToReachResourcesFolder/css/home.css">
    	<script src="https://kit.fontawesome.com/593214b79d.js" crossorigin="anonymous"></script>
	</head>
	<body>
		<div id="main">
	        <div id="header">
	            <i class="fa-solid fa-house-chimney icon-header" style="color: #f0f2f4;"></i>
	            <a href="<%=request.getContextPath()%>/home"><h3>Home Page</h3></a>
	            <ul class="nav-left">
	                <li><a href="<%=request.getContextPath()%>/add">Add</a></li>
	                <li><a href="<%=request.getContextPath()%>/list">List</a></li>
	            </ul>
	
	            <ul class="nav-right">
	                <i class="fa-solid fa-user" style="color: #f0f0f0;"></i>

	                	<c:if test="${not empty useCase.userName}">
	                		<li><a href="<%=request.getContextPath()%>/home">
	                		${useCase.userName}
	                	</c:if>
	                	<c:if test="${empty useCase.userName}">
	                		<li><a href="<%=request.getContextPath()%>/login">
	                		Login
	                	</c:if>
	                		
	                </a></li>
	                <i class="fa-solid fa-user-xmark" style="color: #fafcff;"></i>
	                <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
	            </ul>
	        </div>
	
	        <div id="content">
	            <h2>Welcome to Employee Management System</h2>
	        </div>
	
	        <div id="footer">
	            <i class="fa-regular fa-copyright" style="color: #f7f7f7;"></i>
	            <p>Copyright R2S Academy 2022</p>
	        </div>
	    </div>
	</body>
</html>
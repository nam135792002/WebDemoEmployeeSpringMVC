<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add employee</title>
		<link rel="stylesheet" type="text/css" href="/SpringMVCExample/URLToReachResourcesFolder/css/home.css">
		<link rel="stylesheet" type="text/css" href="/SpringMVCExample/URLToReachResourcesFolder/css/add.css">
    	<script src="https://kit.fontawesome.com/593214b79d.js" crossorigin="anonymous"></script>
    	<script src="/SpringMVCExample/URLToReachResourcesFolder/js/addValidator.js"></script>
	</head>
	<body>
		<input type="hidden" id="status" value="${status}">
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
	            <h2>Add an employee</h2>
	            <form action="addEmployee" method="post" onsubmit="return validateForm();">
	                <div class="fields">
	                    <div class="form-group">
	                        <label id="label-name" for="name">Name: </label>
	                        <input type="text" id="name" name="fullName" placeholder="Enter name" >
	                        <div class="error-message"></div>
	                    </div>
	        
	                    <div class="radio-group form-group">
	                        <label for="gender">Gender: </label>
	                        <input type="radio" name="gender" value="male" id="gender">
	                        <label for="male">Male</label>
	                        <input type="radio" name="gender" value="female" id="gender">
	                        <label for="female">Female</label> <br>
	                        <span id="gender-error" class="error-message"></span>
	                    </div>
	                    
	                    <div></div>
	        
	                    <div class="form-group">
	                        <label for="dateOfBirth">Date of Birth: </label>
	                        <input type="date" id="dateOfBirth" name="dateOfBirth" class="date-picker">
	                        <div class="error-message"></div>
	                    </div>
	        
	                    <div class="form-group">
	                        <label for="option">Department: </label>
	                        <select id="country" name="department.idDepartment">
	                        	<option value="NULL">Choice your department</option>
	                            <c:forEach var="d" items="${listDepartment}">
	                            	<option value="${d.idDepartment}">${d.nameDepartment}</option>
	                            </c:forEach>
	    
	                        </select>
	                        <div class="error-message"></div>
	                    </div>
	                    <div class="form-group button-submit">
	                        <input type="submit" value="Add Employee" class="submit-btn">
	                    </div>
	                </div>
	            </form>
	        </div>
	
	        <div id="footer">
	            <i class="fa-regular fa-copyright" style="color: #f7f7f7;"></i>
	            <p>Copyright R2S Academy 2022</p>
	        </div>
	    </div>
	    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		  <script type="text/javascript">
		  var status = document.getElementById("status").value;
		    if (status === "success") {
		        swal("Congrats", "Add Employee Successfully", "success");
		    }
		    if (status === "failed") {
		        swal("Sorry", "Add Employee Failed", "error");
		    }
		</script>
	</body>
</html>
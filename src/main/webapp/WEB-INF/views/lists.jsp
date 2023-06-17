<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/SpringMVCExample/URLToReachResourcesFolder/css/home.css">
	<link rel="stylesheet" type="text/css" href="/SpringMVCExample/URLToReachResourcesFolder/css/list.css">
	<script src="https://kit.fontawesome.com/593214b79d.js" crossorigin="anonymous"></script>
	<title>List Employee</title>
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
	        <div id="content" style="height: 100%">
	        	<h2>List employee</h2>
	       		<table>
	                <thead>
	                    <tr>
	                        <th>ID Employee</th>
	                        <th>Full Name</th>
	                        <th>Gender</th>
	                        <th>Date Of Birth</th>
	                        <th>Department Name</th>
	                        <th>Option</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach var="e" items="${listEmployee}">
	                        <tr>
	                        	<td>${e.idEmployee}</td>
	                            <td>${e.fullName}</td>
	                            <td>${e.gender}</td>
	                            <td>${e.dateOfBirth}</td>
	                            <td>${e.department.nameDepartment}</td>
	                            <td>
	                            	<a href="<%=request.getContextPath()%>/edit?idEmployee=${e.idEmployee}">
	                            		<button class="button">Edit</button>
	                            	</a> &nbsp;&nbsp;&nbsp;
	                            	
									<a href="#" onclick="confirmDelete('${e.idEmployee}')">
									  <button class="button button3">Delete</button>
									</a>
									
									<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
									<script type="text/javascript">
									  function confirmDelete(employeeId) {
									    swal({
									      title: "Are you sure?",
									      text: "Once deleted, you will not be able to recover this employee!",
									      icon: "warning",
									      buttons: true,
									      dangerMode: true,
									    })
									    .then((willDelete) => {
									      if (willDelete) {
									        swal("Poof! Employee deleted!", {
									          icon: "success",
									        })
									        .then(() => {
									          // Redirect to the delete URL
									          window.location.href = "<%=request.getContextPath()%>/delete?idEmployee=" + employeeId;
									        });
									      } else {
									        swal("Employee not deleted!");
									      }
									    });
									  }
									</script>

								</td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	        </div>
	        <div id="footer">
	            <i class="fa-regular fa-copyright" style="color: #f7f7f7;"></i>
	            <p>Copyright R2S Academy 2022</p>
	        </div>
	    </div>
	    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<script type="text/javascript">
		    var status = "${status}";
		    if (status === "success") {
		        swal("Congrats", "Edit Employee Successfully", "success");
		    }
		    if (status === "failed") {
		        swal("Sorry", "Edit Employee Failed", "error");
		    }
		</script>
</body>
</html>
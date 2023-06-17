<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="/SpringMVCExample/URLToReachResourcesFolder/css/login.css">
    	<script src="/SpringMVCExample/URLToReachResourcesFolder/js/loginValidator.js"></script>
		<style type="text/css">
			#content-form{
			    width: 100%;
				height: 100vh;
				background-image: linear-gradient(rgba(0, 0, 50, 0.5), rgba(0, 0, 50, 0.5)),url("/SpringMVCExample/URLToReachResourcesFolder/img/image.jpg");
				background-position: center;
				background-size: cover;
				position: relative;
			}
			#form-box{
				background-color: white;
			}
		</style>
	</head>
	<body>
		<input type="hidden" id="status" value="${status}">
		<div id="content-form">
			<div class="form-box">
				<form action="loginUseCase" method="post" onsubmit="return validateForm();">
		            <div class="header">
		                <h3>Login</h3>
		            </div>
		            <div class="imgcontainer">
		                <img src="/SpringMVCExample/URLToReachResourcesFolder/img/avatar_icon.png" alt="Avatar" class="avatar">
		            </div>
		    
		            <div class="container">
		                <div class="form-group">
		                    <label for="uname"><b>Username *</b></label>
		                    <input type="text" placeholder="Enter Username" name="username" id="uname">
		                    <div class="error-message"></div>
		                </div>
							
		                <div class="form-group">
		                    <label for="psw"><b>Password *</b></label>
		                    <input type="password" placeholder="Enter Password" name="password" id="psw">
		                    <div class="error-message"></div>
		                </div>
		                    
		                <button type="submit">Login</button>
		                
		                <div class="footer-content">
		            		<a href="register">Click here to Register</a>
		            	</div>
		            </div>
		        </form>
			</div>
	    </div>
	    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<script type="text/javascript">
			var status = document.getElementById("status").value;
			const urlParams = new URLSearchParams(window.location.search);
		    const statusRegister = urlParams.get('status');
			if(status === "failed"){
				swal("Sorry","Login information is incorrect!","error");
			}
			if (statusRegister === "success") {
		        swal("Success", "Account created successfully! Please login.", "success");
		    }
		</script>
	</body>
</html>
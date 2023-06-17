<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register</title>
		<link rel="stylesheet" href="/SpringMVCExample/URLToReachResourcesFolder/css/register.css">
    	<script src="/SpringMVCExample/URLToReachResourcesFolder/js/registerValidator.js"></script>
	</head>
	<body>
		<input type="hidden" id="status" value="${status}">
		<form action="register/save" method="post" onsubmit="return validateForm();">
	        <div class="container">
	            <div class="container-header">
	                <h3>User detail</h3>
	            </div>
	
	            <div class="container-note">
	                <small>**Please fill in this form to create an account.</small>
	            </div>
	
	            <hr>
	            
	            <div class="form-group">
	                <label for="firstName"><b>First Name *</b></label>
	                <input type="text" id="firstName" name="firstName" placeholder="Enter first name" value="${useCase.firstName}">
	                <div class="error-message"></div>
	            </div>
	
	            <div class="form-group">
	                <label for="lastName"><b>Last Name *</b></label>
	                <input type="text" id="lastName" name="lastName" placeholder="Enter last name" value="${useCase.lastName}">
	                <div class="error-message"></div>
	            </div>
	
	            <div class="form-group">
	                <label for="email"><b>Email *</b></label>
	                <input type="text" placeholder="Enter email" name="email" id="email" value="${useCase.email}">
	                <div class="error-message"></div>
	            </div>
	
	            <div class="form-group">
	                <label for="uname"><b>Username *</b></label>
	                <input type="text" placeholder="Enter username" name="userName" id="userName" value="${useCase.userName}">
	                <div class="error-message"></div>
	            </div>
	
	            <div class="form-group">
	                <label for="psw"><b>Password *</b></label>
	                <input type="password" placeholder="Enter password" name="passWord" id="passWord" value="${useCase.passWord}">
	                <div class="error-message"></div>
	            </div>
	      
	            <div class="form-group">
	                <label for="psw-repeat"><b>Confirm Password *</b></label>
	                <input type="password" placeholder="Enter password again" name="psw-repeat" id="psw-repeat" value="${useCase.passWord}">
	                <div class="error-message"></div>
	            </div>
	
	            <hr>
	            
	            <div id="message" style="color: green;"></div>
	            
	            <div class="container-footer">
	                <button type="submit" class="registerbtn">Register</button>
	                <div class="container-signin">
	                	<a href="login">Click here to Login</a>
	                </div>
	            </div>
	        </div>
	      </form>
	      <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		  <script type="text/javascript">
			  var status = document.getElementById("status").value;
			 	if (status === "failed") {
			        swal("Sorry", "Create Account Failed", "error");
			    }
			    else if (status === "failedEmail"){
			    	swal("Sorry","Email was registered before","error");
			    }
			    else if(status === "failedUserName"){
			    	swal("Sorry","Username was registered before","error");
			    }
			</script>
	</body>
</html>
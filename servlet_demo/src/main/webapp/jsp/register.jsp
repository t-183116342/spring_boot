<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>******</title>
		
		<script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/vendor/popper.js/umd/popper.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/vendor/jquery.cookie/jquery.cookie.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/vendor/chart.js/Chart.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/vendor/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/front.js" type="text/javascript"></script>
		
	    <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/fontastic.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
	    <link href="${pageContext.request.contextPath}/static/css/style.default.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/custom.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/img/favicon.ico" type="text/css" rel="shortcut icon">
	</head>
	<body>
		<div class="page login-page">
	      <div class="container d-flex align-items-center">
	        <div class="form-holder has-shadow">
	          <div class="row">
	            <!-- Logo & Information Panel-->
	            <div class="col-lg-6">
	              <div class="info d-flex align-items-center">
	                <div class="content">
	                  <div class="logo">
	                    <h1>Dashboard</h1>
	                  </div>
	                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	                </div>
	              </div>
	            </div>
	            <!-- Form Panel    -->
	            <div class="col-lg-6 bg-white">
	              <div class="form d-flex align-items-center">
	                <div class="content">
	                  <form method="post" action="/doRegister" class="form-validate">
	                  	<c:if test="${message != '' && message != null}">
							<div class="form-group" >
								<div class="alert alert-info alert-dismissable">
									<i class="fa fa-info-circle"></i>
									<strong name="message">${message}</strong>
								</div>
							</div>
						</c:if>
	                    <div class="form-group">
	                      <input id="register-username" type="text" name="userName" required data-msg="Please enter your username" class="input-material">
	                      <label for="register-username" class="label-material">User Name</label>
	                    </div>
	                    <div class="form-group">
	                      <input id="register-password" type="password" name="password" required data-msg="Please enter your password" class="input-material">
	                      <label for="register-password" class="label-material">password</label>
	                    </div>
	                    <div class="form-group terms-conditions">
	                      <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
	                      <label for="register-agree">Agree the terms and policy</label>
	                    </div>
	                    <div class="form-group">
	                      <button id="regidter" type="submit" name="registerSubmit" class="btn btn-primary">Register</button>
	                    </div>
	                  </form><small>Already have an account? </small><a href="/login" class="signup">Login</a>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	      <div class="copyrights text-center">
	        <p>Design by <a href="https://bootstrapious.com" class="external">Bootstrapious</a>
	          <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
	        </p>
	      </div>
	    </div>
	</body>
</html>

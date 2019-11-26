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
										<h1>你想写什么写什么</h1>
									</div>
									<p>真不知道写点什么……</p>
								</div>
							</div>
						</div>
						<!-- Form Panel    -->
						<div class="col-lg-6 bg-white">
							<div class="form d-flex align-items-center">
								<div class="content">
									<form method="post" action="/doLogin" class="form-validate">
										<c:if test="${message != '' && message != null}">
											<div class="form-group" >
												<div class="alert alert-info alert-dismissable">
													<i class="fa fa-info-circle"></i>
													<strong name="message">${message}</strong>
												</div>
											</div>
										</c:if>
										<div class="form-group">
											<input id="login-username" type="text" name="userName" required data-msg="Please enter your username" class="input-material">
											<label for="login-username" class="label-material">User Name</label>
										</div>
										<div class="form-group">
											<input id="login-password" type="password" name="password" required data-msg="Please enter your password" class="input-material">
											<label for="login-password" class="label-material">Password</label>
										</div>
										<input type="submit"  class="btn btn-primary" value="Login"/>
										<!-- This should be submit button but I replaced it with <a> for demo purposes-->
									</form>
									<!-- <a href="#" class="forgot-pass">Forgot Password?</a><br> -->
									<small>Do not have an account? </small><a href="/register" class="signup">Signup</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="copyrights text-center">
				<p>Design by <a href="#" class="external">Hyman</a>
				<!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
				</p>
			</div>
	    </div>
	</body>
</html>

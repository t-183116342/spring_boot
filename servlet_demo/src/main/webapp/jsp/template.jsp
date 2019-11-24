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
	</body>
</html>

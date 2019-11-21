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
		<title>人事管理系统</title>
		
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/jqPaginator.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/common.js" type="text/javascript"></script>
		
		<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/admin.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	</head>
	<body>
	</body>
</html>

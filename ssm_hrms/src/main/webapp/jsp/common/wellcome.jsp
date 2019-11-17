<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>人事管理系统</title>
		
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		
		<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
	    <link href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/admin.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	</head>
	<body style="background-color:#f2f9fd;">
		<div class="x-body">
			<blockquote class="layui-elem-quote">欢迎进入企业资产管理系统！v1.0；登录时间：<span th:text="${loginTime}"></span></blockquote>
			<fieldset class="layui-elem-field">
				<legend>信息总览</legend>
				<div class="layui-field-box">
					<table class="layui-table">
						<thead>
							<tr>
								<th colspan="2" scope="col">您的账户信息</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="30%">您的账号</th>
								<td><span th:text="${user.account}"></span></td>
							</tr>
							<tr>
								<td>您的姓名</td>
								<td><span th:text="${user.userName}"></span></td>
							</tr>
							<tr>
								<td>您的登录时间</td>
								<td><span th:text="${loginTime}"></span></td>
							</tr>
							<tr>
								<td>您的IP地址</td>
								<td><span th:text="${localIp}"></span></td>
							</tr>
						</tbody>
					</table>
					<table class="layui-table">
						<thead>
							<tr>
								<th colspan="2" scope="col">服务器信息</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th width="30%">本系统访问路径</th>
								<td><span th:text="${loacalUrl}"></span></td>
							</tr>
							<tr>
								<td>服务器名称</td>
								<td><span th:text="${serverName}"></span></td>
							</tr>
							<tr>
								<td>服务器ip地址</td>
								<td><span th:text="${localIp}"></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
			<!-- 示例：调用父窗口的某个方法 -->
			<blockquote class="layui-elem-quote layui-quote-nm">
				本系统前端框架支持：X-admin（<a
					onclick="parent.x_admin_show('X-admin主页','http://x.xuebingsi.com/')">http://x.xuebingsi.com/</a>）；
				前端框架整合：胡江（hujiangyx@163.com）； 项目开发：企业资产管理系统（<a
					onclick="parent.x_admin_show('企业资产管理系统主页','http://localhost/login')">http://localhost/login</a>）java
				EE项目组
			</blockquote>
		</div>
	</body>
</html>

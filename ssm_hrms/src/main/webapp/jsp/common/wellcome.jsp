<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>人事管理系统</title>
		
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		
	    <link href="${pageContext.request.contextPath}/static/css/xadmin.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	</head>
	<body style="background-color:#f2f9fd;">
		<div class="x-body">
			<blockquote style="margin-bottom:10px;padding:15px;line-height:22px;border-left:5px solid #009688;border-radius:0 2px 2px 0;background-color:#f2f2f2;">欢迎进入人事管理系统！v1.0；登录时间：${loginTime}</blockquote>
			<fieldset style="margin-bottom:10px;padding:0;border:1px solid #e2e2e2">
				<legend>信息总览</legend>
				<div style="height: 200px;">
					<table class="layui-table" style="width: 60%;margin-bottom:10px;padding:15px;">
						<thead>
							<tr>
								<th colspan="2" scope="col">您的账户信息</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="50%">您的账号</td>
								<td>${user.account}</td>
							</tr>
							<tr>
								<td>您的姓名</td>
								<td>${user.userName}</td>
							</tr>
							<tr>
								<td>登录时间</td>
								<td>${loginTime}</td>
							</tr>
							<tr>
								<td>IP地址</td>
								<td>${localIp}</td>
							</tr>
						</tbody>
					</table>
					<table class="layui-table" style="width: 60%">
						<thead>
							<tr>
								<th colspan="2" scope="col">服务器信息</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="50%">本系统访问路径</td>
								<td>${loacalUrl}</td>
							</tr>
							<tr>
								<td>服务器名称</td>
								<td>${serverName}</td>
							</tr>
							<tr>
								<td>服务器ip地址</td>
								<td>${localIp}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</fieldset>
			<!-- 示例：调用父窗口的某个方法 -->
			<blockquote style="margin-bottom:10px;padding:15px;line-height:22px;border-left:5px solid #009688;border-radius:0 2px 2px 0;background-color:#f2f2f2;">
				本系统前端框架支持：X-admin（<a
					onclick="parent.x_admin_show('X-admin主页','http://x.xuebingsi.com/')">http://x.xuebingsi.com/</a>）；
				<br>
				前端框架整合：胡江（hujiangyx@163.com）； 
				<br>
				项目开发：人事管理系统（<a onclick="parent.x_admin_show('人事管理系统主页','http://localhost:8080/login')">http://localhost:8080/login</a>）java
				EE项目组
			</blockquote>
		</div>
	</body>
</html>

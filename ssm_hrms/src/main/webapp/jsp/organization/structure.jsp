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
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/common.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/jquery.ztree.all.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/organization-list.js" type="text/javascript"></script>
		
		<link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" >
	    <link href="${pageContext.request.contextPath}/static/css/admin.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/zTreeStyle/zTreeStyle.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="panel-head">
			<strong class="icon-reorder"> 内容列表</strong> 
			<a href="" style="float:right; display:none;">添加字段</a>
		</div>
		<div class="x-body">
			<div class="row">
				<!-- 页面左侧（树形结构）部分 -->
				<div class="col-md-2">
					<div class="panel panel-default">
						<div class="panel-heading">人事结构</div>
						<div class="panel-body fullhight">
							<!-- 这里放置左侧内容主体 -->
							<div>
								<ul id="companytree" class="ztree"></ul>
							</div>
							<!-- end 左侧内容 -->
						</div>
					</div>
				</div>
				<!-- end 左侧 -->
				<!-- 页面右侧（详细信息）部分 -->
				<div class="col-md-10" style="width: 80%">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">详细信息</h3>
						</div>
						<div class="panel-body fullhight">
							<!-- 这里放置右侧内容主体 -->
							<span class="message-title">基本信息</span>
							<hr />
							<table>
								<tr>
									<th width="100px">用户账号</th>
									<td width="270px;" id="account">XXXXX</td>
									<th width="100px">入职时间</th>
									<td width="270px;" id="userEntrytime">2017-01-01</td>
								</tr>
								<tr>
									<th>姓名</th>
									<td id="userName">XXX</td>
									<th>学历</th>
									<td id="userDiploma">本科</td>
								</tr>
								<tr>
									<th>出生日期</th>
									<td id="userBirthday">00000000</td>
									<th>状态</th>
									<td>已启用</td>
								</tr>
								<tr>
									<th>性别</th>
									<td id="userSex">男</td>
								</tr>
								<tr>
									<th>所在部门</th>
									<td id="userDepartement">模拟部门</td>
								</tr>
								<tr>
									<th>职务</th>
									<td id="userPosition">部门经理</td>
								</tr>
							</table>
							<br /> <span class="message-title">联系方式</span>
							<hr />
							<table>
								<tr>
									<th width="100px">电话</th>
									<td width="300px;" id="userTelephone">XXXXX</td>
								</tr>
								<tr>
									<th>Email</th>
									<td id="userEmail">xxxxxx@xx.com</td>
								</tr>
								<tr>
									<th>地址</th>
									<td id="userAddress">00000000</td>
								</tr>
	
							</table>
							<!-- end 右侧内容 -->
						</div>
					</div>
				</div>
				<!-- end 右侧 -->
			</div>
		</div>
	</body>
</html>

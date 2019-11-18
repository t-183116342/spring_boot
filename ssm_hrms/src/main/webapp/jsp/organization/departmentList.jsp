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
		<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script> -->
		<script src="${pageContext.request.contextPath}/static/js/jqPaginator.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/static/js/common.js" type="text/javascript"></script>
		
	    <!-- <link href="http://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css" type="text/css" rel="stylesheet"> -->
	    <link href="${pageContext.request.contextPath}/static/css/admin.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<form method="post" action="" id="listform">
			<div class="panel admin-panel">
				<div class="panel-head">
					<strong class="icon-reorder"> 内容列表</strong> 
					<a href="" style="float:right; display:none;">添加字段</a>
				</div>
				<div class="padding border-bottom">
					<ul class="search" style="padding-left:10px;">
						<li> <a class="button border-main icon-plus-square-o" href="/organization/addDepartmentPage"> 增加</a> </li>
						<li>
							<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          					<a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a>
          				</li>
					</ul>
				</div>
				
				<table class="table table-hover text-center">
					<thead>
						<tr>
							<th width="100" style="text-align:center;">ID</th>
					        <th width="300" style="text-align:center;">名称</th>
					        <th width="300" style="text-align:center;">介绍</th>
					        <th width="310" style="text-align:center;">操作</th>
						</tr>
					</thead>
					<tbody id="departments">
					</tbody>
					
					<tr>
						<td colspan="4">
							<ul class="pagination" id="pagination1"></ul>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
	<script type="text/javascript">
		var total = 0;
		var totalPages = 0;
		var visiblePages = 3;
		var currentPage = 0;
		
		$(document).ready(function() {
			
			showPage(-1);
			
			// 分页
			$('#pagination1').jqPaginator({
			    totalPages: totalPages,
			    visiblePages: visiblePages,
			    currentPage: currentPage,
			 
			    first: '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
			    prev: '<li class="prev"><a href="javascript:void(0);">前一页</a></li>',
			    next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
			    last: '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
			    page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
			    onPageChange: function (num) {
			    	showPage(num);
			    }
			});
		});
		
		// 删除
		function del(id) {
			if (confirm('确定要删除吗')==true) {
				$.ajax({
					type : "POST",
					async:false,
					data : {
						departId:id
					},
					dataType : "text",
					url : "/organization/deleteDepartment",
					success : function(data) {
						var result = eval("(" + data + ")");
		    			if (result.status == 200) {
							console.log(result);
							location.replace(location.href);
						} else {
							alert(result.message);
						}
					},
					error : function() {
						alert("无法连接服务器");
					}
				});
			}
		}
		
		// 分页
		function showPage(n) {
			$.ajax({
				type : "POST",
				async:false,
				data : {
					currentPage:n
				},
				dataType : "text",
				url : "/organization/departments",
				success : function(result) {
					console.log(result);
					var tl = eval("(" + result + ")");
					if(n==-1){
						total = tl.total;
						totalPages = tl.pages;
						currentPage = tl.pageNum;
					}
					$("#departments").html("");
					if(tl.list.length>0){
						$.each(tl.list, function(n,val){
							console.log(n);
							var str="";
						    str+="<tr>";
						    str+="<td>"+getDefaultString(val.departId)+"</td>"
						    str+="<td>"+getDefaultString(val.departName)+"</td>"
						    str+="<td>"+getDefaultString(val.departDesc)+"</td>"
						    str+="<td><div class='button-group'><a class='button border-main' href='/organization/updateDepartmentPage?departId=" + val.departId + "'><span class='icon-edit'></span>修改</a><a class='button border-red' href='javascript:void(0)' onclick='del(" + val.departId + ")'><span class='icon-trash-o'></span>删除</a></div></td>"
						    str+="</tr>";
							$("#departments").append(str);
						})
					}else{
						$("#departments").append("<tr><td colspan=8 align=\"center\">暂时没有数据哦，快去添加一条吧</td></tr>");
					}
				},
				error : function() {
					layer.msg('无法连接服务器', {icon: 2});
				}
			});
		}
		
	</script>
</html>

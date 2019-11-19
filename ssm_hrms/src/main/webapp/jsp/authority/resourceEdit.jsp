<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>人事管理系统</title>
		
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/admin.css" type="text/css" rel="stylesheet">
		<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="panel admin-panel">
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改资源</strong></div>
			<div class="body-content">
			
				<!-- message -->
				<div name="messageDiv" class="row" style="display:none;">
					<div class="col-lg-12">
						<div class="alert alert-info alert-dismissable">
							<i class="fa fa-info-circle"></i> <strong name="message" style="color: red;"></strong>
						</div>
					</div>
				</div>
				
				<form id="form1" method="post" class="form-x" action="cdsacdas">
					<input type="hidden" name="resourceId" value="${resource.resourceId}" />
					<div class="form-group">
						<div class="label">
							<label>资源名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${resource.resourceName}" name="resourceName" data-validate="required:请输入部门名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>资源Url：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${resource.resourceUrl}" name="resourceUrl" data-validate="required:请输入部门描述" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>资源描述：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${resource.resourceDescription}" name="resourceDescription" data-validate="required:请输入部门描述" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>指定角色：</label>
						</div>
						<div class="field" style="padding-top:3px;">
							<c:forEach items="${roles}" var="role">
								<input name="roleCheckbox" type="checkbox" value="${role.roleId}" 
									<c:if test="${role.selected}">checked</c:if> 
								/>
								${role.roleDesc}
							</c:forEach>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label></label>
						</div>
						<div class="field">
							<button class="button bg-main icon-check-square-o" name="submitButton"> 提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(document).ready(function() {
			
			// 添加
			$("[name=submitButton]").bind("click", function() {
				var resourceName = $("[name=resourceName]").val();
				var resourceUrl = $("[name=resourceUrl]").val();
				var resourceDescription = $("[name=resourceDescription]").val();
				if (resourceName == "" || resourceDescription == "" || resourceUrl == "") {
					$("[name=messageDiv]").show();
					$("[name=message]").text("请输入内容");
					return false;
				} else {
					var resource = {};
					resource.resourceId = $("[name=resourceId]").val();
					resource.resourceName = $("[name=resourceName]").val();
					resource.resourceUrl = $("[name=resourceUrl]").val();
					resource.resourceDescription = $("[name=resourceDescription]").val();
					var roles = new Array();
					$.each($("input[name='roleCheckbox']"), function(){
			   			if(this.checked){
			   				var role = {};
			   				role.roleId = $(this).val();
			   				roles.push(role);
			   			}
			   		});
					resource.roles = roles;
					
					$.ajax({
						url :"/authority/editResource",
						type : "POST",
						contentType: "application/json",
			       		data : JSON.stringify(resource),
						success : function(result) {
							if (result.status == 200) {
								$("[name=messageDiv]").hide();
								location.replace("/authority/resourceListPage")
							} else {
								$("[name=messageDiv]").show();
								$("[name=message]").text(result.message);
							}
		 				},
						error : function() {
							$("[name=messageDiv]").show();
							$("[name=message]").text("无法连接服务器");
						}
					});
					return false;
				}
			});
		});
	</script>
</html>
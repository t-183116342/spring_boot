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
			<div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改职位</strong></div>
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
					<input type="hidden" name="positionId" value="${position.positionId}"/>
					<div class="form-group">
						<div class="label">
							<label>职位名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${position.positionName}" name="positionName" data-validate="required:请输入部门名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>职位描述：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" value="${position.positionDescription}" name="positionDescription" data-validate="required:请输入部门描述" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>所属部门：</label>
						</div>
						<div class="field">
							<select name="departId" class="input w50">
								<c:forEach items="${departments}" var="department">
									<option 
										<c:if test="${position.departId==department.departId }">selected='selected'</c:if> 
										value="${department.departId}">${department.departName}</option>
								</c:forEach>
							</select>
							<div class="tips"></div>
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
			
			// 编辑
			$("[name=submitButton]").bind("click", function() {
				var positionName = $("[name=positionName]").val();
				var positionDescription = $("[name=positionDescription]").val();
				if (positionName == "" || positionDescription == "") {
					$("[name=messageDiv]").show();
					$("[name=message]").text("请输入内容");
					return false;
				} else {
					$.ajax({
						url :"/organization/editPosition",
						type : "POST",
						data : $('#form1').serialize(),
						dataType : "text",
						success : function(data) {
							var result = eval("(" + data + ")");
							if (result.status == 200) {
								$("[name=messageDiv]").hide();
								location.replace("/organization/positionListPage")
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
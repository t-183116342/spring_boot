<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	    <meta name="renderer" content="webkit">
	    <title>HRMS Login</title>
	    
	    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/hrms.js" type="text/javascript"></script>
		
	    <link href="${pageContext.request.contextPath}/static/css/admin.css" type="text/css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div class="bg"></div>
		<div class="container">
		    <div class="line bouncein">
		        <div class="xs6 xm4 xs3-move xm4-move">
		            <div style="height:60px;"></div>
		            <div class="media media-y margin-big-bottom">           
		            </div>         
		            <form method="post">
			            <div class="panel loginbox">
			                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
			                <div id="errorMessage" class="text-center" style="color: red;"></div>
			                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="text" class="input input-big" name="account" placeholder="登录账号" data-validate="required:请填写账号" />
			                            <span class="icon icon-user margin-small"></span>
			                        </div>
			                    </div>
			                    <div class="form-group">
			                        <div class="field field-icon-right">
			                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
			                            <span class="icon icon-key margin-small"></span>
			                        </div>
			                    </div>
			                </div>
			                <div style="padding:10px;">
			                	<input type="button" id="registerButton" class="button button-block bg-main text-big input-big" value="注册">
			                </div>
			                <div class="form-group" style="padding:10px;">
								<div style="float:right;"><a href="/login">登录</a></div>
							</div>
			            </div>
		            </form>          
		        </div>
		    </div>
		</div>
	</body>
	<style>
		.input-val {
	        float: left;
	        width: 225px!important;;
	        background: #ffffff;
	        height: 45px!important;;
	        padding: 0 2%;
	        border-radius: 5px;
	        border: none;
	        border: 1px solid rgba(0,0,0,.2);
	    }
		#canvas {
	        float: right;
	        display: inline-block;
	        border: 1px solid #ccc;
	        border-radius: 5px;
	        cursor: pointer;
	    }
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			 * 用户注册
			 */
			$("#registerButton").bind("click", function() {
				var user = {};
				user.account = $("[name='account']").val();
				user.password = $("[name='password']").val();
				$.ajax({
					url : "/doRegister",
					type : "post",
					contentType: "application/json",
					data : JSON.stringify(user),
					success : function (data) {
						if (data.status == 200) {
							location.href = "/login";
						} else {
							$("#errorMessage").text(data.message);
						}
					},
					error : function (data) {
						$("#errorMessage").text(data.responseText);
					}
				});
			});
		});
	</script>
</html>
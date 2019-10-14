<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>HRMS Login</title>
		
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/hrms.js"></script>
		
		<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
	    <link rel="stylesheet" href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/hrms.css" type="text/css">
	</head>
	<body class="login">
		<div class="container-fluid">
			<div class="row">
		        <div class="col-md-4 col-md-offset-4" style="margin-top:150px">
		            <div class="login-panel panel panel-default" >
		                <div class="panel-heading">
		                    <h3 class="panel-title" style="text-align: center;">HRMS111111</h3>
		                </div>
		                <div class="panel-body">
		                    <form role="form" action="#" method="post" id="login_form">
		                        <fieldset>
		                            <div class="form-group">
		                                <input class="form-control" placeholder="用户名:admin" name="username" autofocus>
		                            </div>
		                            <div class="form-group">
		                                <input class="form-control" placeholder="密码:1234" name="password" type="password" value="">
		                            </div>
		                            <a href="javascript:void(0)" class="btn btn-lg btn-success btn-block" id='login_btn'>登录</a>
		                            <div style="float:right;"><a href="/hrms/login">立即注册</a></div>
		                        </fieldset>
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</body>
</html>
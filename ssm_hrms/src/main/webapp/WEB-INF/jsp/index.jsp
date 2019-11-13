<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	    <title>HRMS</title>
	    
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
	    <!-- 导航条 -->
	    <%@ include file="./commom/head.jsp"%>
	    <!-- 左侧栏 -->
		<%@ include file="./commom/leftSideBar.jsp"%>
		<div class="hrms_container">
		
		    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
		    <div class="hrms_body" style="position:relative; top:-15px;">
		
		        <!-- 左侧栏 -->
		        <%@ include file="./commom/leftSideBar.jsp"%>
		
		        <!-- 中间轮播图内容 -->
		        <div class="hrms_main_ad col-sm-10">
		            <div class="panel panel-success">
		                <div class="panel-heading">
		                    <h3 style="text-align: center;">欢迎进入XXX公司人力资源管理系统！</h3>
		                </div>
		                <div class="panel-body" style="position:relative; top:-15px;">
		                    <div id="hrms_carousel_1" class="carousel slide" data-ride="carousel">
		                        <ol class="carousel-indicators">
		                            <li data-target="#hrms_carousel_1" data-slide-to="0" class="active"></li>
		                            <li data-target="#hrms_carousel_1" data-slide-to="1"></li>
		                            <li data-target="#hrms_carousel_1" data-slide-to="2"></li>
		                        </ol>
		
		                        <div class="carousel-inner" role="listbox">
		                            <div class="item active" style="text-align: center;">
		                                <img class="img-responsive center-block" src="/static/images/company1.jpg" alt="company1">
		                                <div class="carousel-caption">
		                                    <h3>漂亮大气的办公楼</h3>
		                                </div>
		                            </div>
		                            <div class="item">
		                                <img class="img-responsive center-block" src="/static/images/company2.jpg" alt="company2">
		                                <div class="carousel-caption">
		                                    <h3>休闲的放松场所</h3>
		                                </div>
		                            </div>
		                            <div class="item">
		                                <img class="img-responsive center-block" src="/static/images/company3.jpg" alt="company3">
		                                <div class="carousel-caption">
		                                    <h3>舒适的办公环境</h3>
		                                </div>
		                            </div>
		                        </div>
		
		                        <!-- Controls -->
		                        <a class="left carousel-control" href="#chrms_carousel_1" role="button" data-slide="prev">
		                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		                            <span class="sr-only">Previous</span>
		                        </a>
		                        <a class="right carousel-control" href="#hrms_carousel_1" role="button" data-slide="next">
		                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		                            <span class="sr-only">Next</span>
		                        </a>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		    
		    <!-- 尾部 -->
		    <%@ include file="./commom/foot.jsp"%>
		</div>
	</body>
</html>

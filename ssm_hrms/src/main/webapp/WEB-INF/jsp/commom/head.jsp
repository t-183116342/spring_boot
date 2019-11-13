<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header bg-main">
	<div class="logo margin-big-left fadein-top">
		<h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />教务管理系统</h1>
	</div>
	<div class="head-l">
		<a class="button button-little bg-green" href="" target="_blank">
			<span class="icon-home"></span> 前台首页
		</a> &nbsp;&nbsp;
		<a href="##" class="button button-little bg-blue">
			<span class="icon-wrench"></span> 清除缓存
		</a> &nbsp;&nbsp;
		<a class="button button-little bg-red" href="login.html">
			<span class="icon-power-off"></span> 退出登录
		</a>
	</div>
</div>
<script type="text/javascript">
    //主页面
    $("#company_logo").click(function () {
        $(this).attr("href", "/hrms/main");
    });
    //账号退出
    $(".hrms_logout").click(function () {
        window.location.href = "/hrms/logout";
    });
</script>

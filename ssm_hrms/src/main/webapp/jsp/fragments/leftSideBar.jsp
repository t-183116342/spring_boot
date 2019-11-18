<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="leftnav">
	<div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
	<h2><span class="icon-user"></span>组织管理</h2>
	<ul>
		<li><a href="/organization/departmentListPage" target="right"><span class="icon-caret-right"></span>部门信息</a></li>
		<li><a href="/organization/positionListPage" target="right"><span class="icon-caret-right"></span>职业信息</a></li>
	</ul> 
	<h2><span class="icon-user"></span>权限管理</h2>
	<ul>
		<li><a href="info.html" target="right"><span class="icon-caret-right"></span>考试项目设置管理</a></li>
		<li><a href="pass.html" target="right"><span class="icon-caret-right"></span>考试报名管理</a></li>
	</ul>  
	<h2><span class="icon-user"></span>人事管理</h2>
	<ul>
		<li><a href="/account/userListPage" target="right"><span class="icon-caret-right"></span>雇员信息</a></li>  
		<li><a href="/organization/structure" target="right"><span class="icon-caret-right"></span>人事结构</a></li>    
	</ul> 
</div>
<ul class="bread">
	<li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
	<li><a href="##" id="a_leader_txt">网站信息</a></li>
	<li><b>当前语言：</b><span style="color:red;">中文</php></span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>

<script type="text/javascript">
	$(function(){
		$(".leftnav h2").click(function(){
			$(this).next().slideToggle(200);	
			$(this).toggleClass("on"); 
		})
		$(".leftnav ul li a").click(function(){
		    $("#a_leader_txt").text($(this).text());
	  		$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
</script>
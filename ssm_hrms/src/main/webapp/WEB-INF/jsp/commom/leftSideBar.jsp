<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="leftnav">
	<div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
	<h2><span class="icon-user"></span>基本信息管理</h2>
	<ul style="display:block">
		<li><a href="info.html" target="right"><span class="icon-caret-right"></span>学生基本信息管理</a></li>
		<li><a href="pass.html" target="right"><span class="icon-caret-right"></span>教师基本信息管理</a></li>
		<li><a href="page.html" target="right"><span class="icon-caret-right"></span>院系基本信息管理</a></li>  
		<li><a href="adv.html" target="right"><span class="icon-caret-right"></span>专业信息维护</a></li>   
		<li><a href="book.html" target="right"><span class="icon-caret-right"></span>班级信息维护</a></li>     
		<li><a href="column.html" target="right"><span class="icon-caret-right"></span>课程总库维护</a></li>
		<li><a href="column.html" target="right"><span class="icon-caret-right"></span>开课课程管理</a></li>
	</ul> 
	<h2><span class="icon-user"></span>考试报名系统</h2>
	<ul style="display:block">
		<li><a href="info.html" target="right"><span class="icon-caret-right"></span>考试项目设置管理</a></li>
		<li><a href="pass.html" target="right"><span class="icon-caret-right"></span>考试报名管理</a></li>
		<li><a href="page.html" target="right"><span class="icon-caret-right"></span>考试成绩管理</a></li>  
	</ul>  
	<h2><span class="icon-user"></span>选课管理</h2>
	<ul style="display:block">
		<li><a href="info.html" target="right"><span class="icon-caret-right"></span>学生网上选课</a></li>
		<li><a href="pass.html" target="right"><span class="icon-caret-right"></span>选课数据调整</a></li>
		<li><a href="page.html" target="right"><span class="icon-caret-right"></span>选课结果查询</a></li>  
		<li><a href="adv.html" target="right"><span class="icon-caret-right"></span>选课结果统计</a></li>   
		<li><a href="book.html" target="right"><span class="icon-caret-right"></span>生成课表</a></li>     
	</ul> 
	<h2><span class="icon-pencil-square-o"></span>成绩管理</h2>
	<ul>
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span></a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>学生证管理</a></li>
		<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>学籍异动信息管理</a></li> 
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span>辅修信息管理</a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>专业中期分渡</a></li>
		<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>推荐免试研究生</a></li>  
		<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>毕业管理</a></li>         
	</ul>    
	<h2><span class="icon-pencil-square-o"></span>学籍管理</h2>
	<ul>
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span>学籍信息管理</a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>学生证管理</a></li>
		<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>学籍异动信息管理</a></li> 
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span>辅修信息管理</a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>专业中期分渡</a></li>
		<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>推荐免试研究生</a></li>  
		<li><a href="cate.html" target="right"><span class="icon-caret-right"></span>毕业管理</a></li>         
	</ul>  
	<h2><span class="icon-pencil-square-o"></span>开课计划</h2>
	<ul>
		<li><a href="list.html" target="right"><span class="icon-caret-right"></span>开课计划制定</a></li>
		<li><a href="add.html" target="right"><span class="icon-caret-right"></span>开课计划审批</a></li>
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
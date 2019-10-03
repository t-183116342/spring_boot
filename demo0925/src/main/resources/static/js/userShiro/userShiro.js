$(document).ready(function() {
	
	/*
	 * 控制导航栏active属性
	 */
	$('.nav li a').each(function(){  
		if($($(this))[0].href==String(window.location))  
			$(this).parent().addClass('active');  
	});
	
	/*
	 * 用户注册
	 */
	$("#registerButton").bind("click", function() {
		var user = {};
		user.userName = $("[name='userName']").val();
		user.password = $("[name='password']").val();
		$.ajax({
			url : "/shiro/doRegister",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(user),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/shiro/dashboard";
				} else {
					$("#message").html(data.message);
				}
			},
			error : function (data) {
				$("#message").html(data.responseText);
			}
		});
	});
	
	/*
	 * 用户注登录
	 */
	$("#loginButton").bind("click", function() {
		var user = {};
		user.userName = $("[name='userName']").val();
		user.password = $("[name='password']").val();
		$.ajax({
			url : "/shiro/doLogin",
			type : "post",
			contentType: "application/json",
			data : JSON.stringify(user),
			success : function (data) {
				if (data.status == 200) {
					location.href = "/shiro/dashboard";
				} else {
					$("#message").html(data.message);
				}
			},
			error : function (data) {
				$("#message").html(data.responseText);
			}
		});
	});
	
	$("#codePic").bind("click", function() {
		$("#codePic").attr("src", "/getGifCode?flag=" + Math.random());
	});
	
	function sendAjax() {
		var username = $("#username").val();
		var password = $("#password").val();
		var vcode = $("#vcode").val();
		var rememberMe = $('#rememberMe').is(':checked');
		$.ajax({
			url : "/ajaxLogin",
			data : {
				"username" : username,
				"password" : password,
				"vcode" : vcode,
				"rememberMe" : rememberMe
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.status == 200) {
					location.href = "/index";
				} else if (data.status == 400) {
					location.href = "/lock";
				} else if (data.status == 100) {
					$("#erro1").html("密码错误，您还有：" + data.message + " 次机会");
				} else if (data.status == 600) {
					$("#erro1").html("账号不存在,您还有：" + data.message + " 次机会");
				} else if (data.status == 300) {
					$("#erro1").html("账号不存在,您还有：" + data.message + " 次机会");
				} else {
					$("#erro1").html(data.message);
				}
			},
			error : function() {
				$("#erro").html("登录失败");
			}
		});
	}
	
});
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>css3炫酷登录页</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="${ctx}/src/login/css/style.css"/>
  <link rel="stylesheet" type="text/css" href="${ctx}/src/login/css/reset.css"/>
	<%-- 导入jquery --%>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/axios/0.18.0/axios.min.js"></script>
</head>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${ctx}/src/login/img/name.png"/></div>
				<div class="login-center-input">
					<input id="name" type="text" name="" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${ctx}/src/login/img/password.png"/></div>
				<div class="login-center-input">
					<input id="password" type="password" name=""value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-button">
				登陆
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="${ctx}/src/login/js/particles.min.js"></script>
<script src="${ctx}/src/login/js/app.js"></script>
<script type="text/javascript">
	function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	 
	function removeClass(ele, cls) {
	  if (hasClass(ele, cls)) {
	    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	      newClass = newClass.replace(' ' + cls + ' ', ' ');
	    }
	    ele.className = newClass.replace(/^\s+|\s+$/g, '');
	  }
	}
		document.querySelector(".login-button").onclick = function(){
				addClass(document.querySelector(".login"), "active")
				setTimeout(function(){
					addClass(document.querySelector(".sk-rotating-plane"), "active")
					document.querySelector(".login").style.display = "none"
				},800)
				setTimeout(function(){
					removeClass(document.querySelector(".login"), "active")
					removeClass(document.querySelector(".sk-rotating-plane"), "active")
					document.querySelector(".login").style.display = "block"
					// alert("登录成功")
					axios
							.post('${ctx}/Login/LoginServlet', {
								name: $("#name").val(),
								password: $("#password").val()
							})
							.then(function (response) {
								if (response.data=="false"){
									alert("用户名或密码错误");
								}
								if (response.data=="success"){
									alert("登录成功，欢迎光临");
									//页面跳转
									$(location).attr('href', 'http://www.cerambycidae.org.cn/');
									return false;
								}
							})
							.catch(function (error) {
								alert(error)
							});
					return false;
				},4000)



		}
</script>
</body>
</html>
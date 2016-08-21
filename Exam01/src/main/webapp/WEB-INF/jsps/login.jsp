<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>登录界面</title>
	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
	<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="<%= basePath %>resources/css/login.css"  type="text/css" />

</head>
<body >
	<div id="main">
		<div id="title">
			<h3>10891-唐飞</h3>
		</div>

		<div id="content">
			<div id="film">
				<h4>电影租赁管理系统</h4>
			</div>
			<div id="login">
				<form action="<%= basePath %>/dologin" id="mainForm" method="post"    class="form-horizontal" role="form">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="userName" name="userName"	placeholder="用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="password" name="password" placeholder="密码">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-5">
							<button type="submit" class="btn btn-default">登录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>


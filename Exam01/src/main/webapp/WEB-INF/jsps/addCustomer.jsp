<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>

<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<%=basePath%>resources/css/index.css"
	type="text/css" />
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script src="<%=basePath%>resources/js/back/list.js"></script>

</head>
<body>

	<script type="text/javascript">
		var msg = ${requestScope.msg};
		alert(msg);
	</script>

	<div id="head">
		<div id="user">
			<h4>10891-唐飞</h4>
		</div>
		<div id="admin">
			<a href="#"><h4>Admin</h4></a>
		</div>

	</div>

	<div id="content">
		<div id="navigation">
			<ul style="margin-top:2px" class="nav nav-pills nav-stacked">
				<li style="background-color:#E8CCFF"><a href="<%=basePath%>/customer/allCustomers">Customer管理</a></li>
				<li style="background-color:#E8CCFF"><a href="#">Film设置</a></li>
			</ul>
		</div>

		<div id="film">
			<div id="table">
				<form action="<%=basePath%>/customer/addCustomer" id="mainForm"
					method="post">
					<div class="right">
						<div class="current">创建Customer</div>
						<div class="rightCont">
							<p class="g_title fix">基本信息&nbsp;&nbsp;&nbsp;&nbsp;</p>
							<table class="tab1">
								<tbody>
									<tr>
									</tr>
								</tbody>
							</table>
							<div class="zixun fix">
								<div class="col-lg-8">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">Firsr
												Name*</button>
										</span> <input name="first_name" type="text" class="form-control">
									</div>
								</div>
								<br />
								<div class="col-lg-8">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">Last
												Name*</button>
										</span> <input name="last_name" type="text" class="form-control">
									</div>
								</div>
								<br />
								<div class="col-lg-8">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">Email</button>
										</span> <input name="email" type="text" class="form-control">
									</div>
								</div>
								<br />
								<div class="col-lg-8">
									<div class="input-group">
										<span class="input-group-btn">
											<button class="btn btn-default" type="button">&nbsp;&nbsp;&nbsp;Address*</button>
										</span>
										<div class="col-lg-16">
											<select id="address" name="address" class="form-control">
												<c:forEach items="${addressObjects}" var="add2"
													varStatus="status">
													<option>${ add2.address }</option>
												</c:forEach>

											</select>
										</div>
									</div>
								</div>
								<br />
								<div id="last" class="col-lg-8">
									<button id="fat-btn" class="btn btn-primary" type="submit">新建</button>
									<button id="fat-btn" class="btn btn-primary" type="button">取消</button>
								</div>
							</div>
						</div>
					</div>
				</form>

			</div>

		</div>
	</div>
</body>
</html>
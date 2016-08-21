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
<script src="http://libs.baidu.com/jQuery/1.10.2/jquery.min.js"></script>

<link rel="stylesheet" href="<%=basePath%>resources/css/index.css"
	type="text/css" />
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script src="<%=basePath%>resources/js/back/list.js"></script>
<script src="<%=basePath%>resources/js/front/modify.js"></script>

</head>
<body>
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
				<form action="<%=basePath%>/customer/allCustomers" id="mainForm" method="post">
					<input type="hidden" name="currentPage" id="currentPage"value="${page.currentPage}" />

					<div class="right">
						<div class="current">客户管理</div>
						<div class="rightCont">
							<p class="g_title fix">
								客户列表 <a class="btn03" href="<%=basePath%>/customer/addCustomer">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</p>
							<table class="tab1">
								<tbody>
									<tr>
										<input type="hidden" id="basePath" value="<%=basePath%>"/>
									</tr>
								</tbody>
							</table>
							<div class="zixun fix">
								<table class="tab2" width="100%">
									<tbody>
										<tr>
										   <th>Oprator</th>
											<th>FirstName</th>
											<th>LastName</th>
											<th>Address</th>
											<th>Email</th>
											<th>CustomerId</th>
											<th>LastUpdate</th>
										</tr>
										<c:forEach items="${customers}" var="customer" varStatus="status">
											<tr
												<c:if test="${status.index % 2 != 0}">style='background-color:#ECF6EE;'</c:if>>
												<td><a onclick="modify(${customer.customer_id})"data-toggle="modal" data-target="#myModal">修改</a>&nbsp;|&nbsp;
													<%-- <a href="${basePath}DeleteOneServlet.action?id=${customer.customer_id}">删除</a> --%>
													<a href="#">删除</a></td>
												<td>${customer.first_name}</td>
												<td>${customer.last_name}</td>
												<td>${adds[status.index]}</td>
												<td>${customer.email}</td>
												<td>${customer.customer_id}</td>
												<td>${customer.last_update}</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class='page fix'>
									共 <b>${page.totalNumber}</b> 条
									<c:if test="${page.currentPage != 1}">
										<a href="javascript:changeCurrentPage('1')" class='first'>首页</a>
										<a
											href="javascript:changeCurrentPage('${page.currentPage-1}')"
											class='pre'>上一页</a>
									</c:if>
									当前第<span>${page.currentPage}/${page.totalPage}</span>页
									<c:if test="${page.currentPage != page.totalPage}">
										<a
											href="javascript:changeCurrentPage('${page.currentPage+1}')"
											class='next'>下一页</a>
										<a href="javascript:changeCurrentPage('${page.totalPage}')"
											class='last'>末页</a>
									</c:if>
									跳至&nbsp;<input id="currentPageText" type='text'
										value='${page.currentPage}' class='allInput w28' />&nbsp;页&nbsp;
									<a
										href="javascript:changeCurrentPage($('#currentPageText').val())"
										class='go'>GO</a>
								</div>
							</div>
						</div>
					</div>
					
				</form>

			</div>

		</div>
	</div>





	<!-- bootstrap的modal -->

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
				<%-- <form action="<%=basePath%>/customer/modifyCustomer " method="POST"> --%>
					
					<div class="modal-body" style="height: 250px;">
						<div class="col-lg-8">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Firsr
										Name*</button>
								</span> <input id="first_name" name="first_name" type="text"
									class="form-control">
							</div>
						</div>
						<br />
						<div class="col-lg-8">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">Last
										Name*</button>
								</span> <input id="last_name" name="last_name" type="text"
									class="form-control">
							</div>
						</div>
						<br />
						<div class="col-lg-8">
							<div class="input-group">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email&nbsp;</button>
								</span> <input id="email" name="email" type="text" class="form-control">
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
										<c:forEach items="${addressObjects}" var="add2" varStatus="status">
											<option>${ add2.address }</option>
										</c:forEach>
										
									</select>	
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="modifybtn" type="button"   class="btn btn-primary">提交更改</button>
					</div>
					<input type="hidden" name="customer_id" id="customer_id" />
				<!-- </form> -->
			</div>
		</div>
</body>
</html>
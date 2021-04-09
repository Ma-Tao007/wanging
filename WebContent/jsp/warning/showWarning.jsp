<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>预警信息显示</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
	<style>
		table{
			margin: 0px;
			padding: 0px;
			border-collapse: collapse;
			table-layout: fixed;  /*不添加此样式，会全部显示    */
		}
		table td{
			border: 1px solid #eef2e9;
			text-overflow: ellipsis; /* 加上，显示省略号*/
			white-space: nowrap;
			overflow: hidden;
		}
	</style>
</head>
<body>
	<!-- 顶栏 -->

	<!-- 中间主体 --><jsp:include page="../top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="../menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 class="col-md-5">学生预警信息</h1>
						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>学号</th>
									<th>学生姓名</th>
									<th>应修课程数</th>
									<th>不及格数</th>
									<th>预警情况</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${warn}" var="item"  >
								<tr>
									<td>${item.sno}</td>
									<td>${item.sname}</td>
									<td>${item.sum}</td>
									<td>${item.nsum}</td>
									<td>${(item.nsum<3*item.sum/4)?((item.nsum<item.sum/2)?((item.nsum<item.sum/4)?"正常":"红色"):"延长修读"):"建议退学"}</td>
								</tr>
							</c:forEach>
					        </tbody>
				    </table>
				</div>

			</div>
		</div>
	</div>
	<div class="container" id="footer">
		<div class="row">
			<div class="col-md-12"></div>
		</div>
	</div>
<input hidden id="contextPath" value="${pageContext.request.contextPath}">
</body>
</html>
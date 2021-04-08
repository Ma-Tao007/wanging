<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>药品信息显示</title>

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
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 class="col-md-5">学生管理</h1>

							<button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='student?method=addPage'">
								添加学生信息
								<sapn class="glyphicon glyphicon-plus"/>
							</button>

						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>学号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>专业</th>
									<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${nlist}" var="item" varStatus="i" >
								<tr>
									<td>${item.sno}</td>
									<td>${item.sname}</td>
									<td>${item.ssex}</td>
									<td>${item.sage}</td>
									<td>${item.sdept}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='student?method=editPage&id=${item.sno}'">修改</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="confirmd(${item.sno})">删除</button>
										<!--弹出框-->
									</td>
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
	<script type="text/javascript">
		var contextPath = $("#contextPath").val()

        function confirmd(id) {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                location.href='student?method=delete&sno='+id;
            }else{
                return false;
            }
        }

        $("#sub").click(function () {
            $("#form1").submit();
        });

	</script>
</html>
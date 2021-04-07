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
					    	<h1 class="col-md-5">药品管理</h1>
							<form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="drug?method=findByName" id="form1" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入药品名称" name="findByName">
									<span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='drug?method=addPage'">
								添加药品信息
								<sapn class="glyphicon glyphicon-plus"/>
							</button>

						</div>
				    </div>
				    <table class="table table-bordered">
					        <thead>
					            <tr>
									<th>序号</th>
									<th>药品名称</th>
									<th>价格</th>
									<th>库存数量</th>
									<th>录入时间</th>
									<th>操作</th>
					            </tr>
					        </thead>
					        <tbody>
							<c:forEach  items="${nlist}" var="item" varStatus="i" >
								<tr>
									<td>${i.index+1 }</td>
									<td>${item.drugname}</td>
									<td>${item.price}</td>
									<td>${item.num}</td>
									<td>${item.inputtime}</td>
									<td>
										<button class="btn btn-default btn-xs btn-info" onClick="location.href='drug?method=editPage&id=${item.id}'">修改</button>
										<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="confirmd(${item.id})">删除</button>
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
        <c:if test="${pagingVO != null}">
			if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
				$(".pagination li:last-child").addClass("disabled")
			};

			if (${pagingVO.curentPageNo} == ${1}) {
				$(".pagination li:nth-child(1)").addClass("disabled")
			};
        </c:if>

        function confirmd(id) {
            var msg = "您真的确定要删除吗？！";
            if (confirm(msg)==true){
                location.href='drug?method=delete&id='+id;
            }else{
                return false;
            }
        }

        $("#sub").click(function () {
            $("#form1").submit();
        });

	</script>
</html>
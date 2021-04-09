<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 顶栏 -->
	<jsp:include page="../top.jsp"></jsp:include>
	<!-- 中间主体 -->
		<div class="container" id="content">
		<div class="row">
			<jsp:include page="../menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
				    <div class="panel-heading">
						<div class="row">
					    	<h1 style="text-align: center;">添加学生成绩信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="grade?method=add" id="editfrom" method="post" onsubmit="return submit()">
							<div class="form-group">
								<label  class="col-sm-2 control-label">学生</label>
								<div class="col-sm-10">
									<select class="selectpicker form-control"  name="sno">
										<c:forEach items="${slist}" var="stu">
											<option value="${stu.sno}">${stu.sname}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">课程</label>
								<div class="col-sm-10">
									<input type="text" required="required" class="form-control" id="cname" name="cname" placeholder="请输入课程" >
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">学分</label>
								<div class="col-sm-10">
									<input type="number" required="required" class="form-control" id="credit" name="credit" placeholder="请输入学分" >
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">成绩</label>
								<div class="col-sm-10">
									<input type="number" required="required" class="form-control" id="grade" name="grade" placeholder="请输入成绩" >
								</div>
							</div>
							  <div class="form-group" style="text-align: center">
								<button class="btn btn-default" type="submit">提交</button>
								<button class="btn btn-default" type="reset">重置</button>
							  </div>
						</form>
				    </div>
				    
				</div>

			</div>
		</div>
	</div>
</body>
	<script type="text/javascript">
		
        function submit(){
        	alert("验证")
            if($("#drugname").val()=="" || $("#drugname").val()==null){
                alert("请输入药品名称")
                return false
            }
            if($("#price").val()=="" || $("#price").val()==null){
                alert("请输入价格")
                return false
            }
            if($("#num").val()=="" || $("#num").val()==null){
                alert("请输入数量")
                return false
            }
            return true
        }
	</script>
</html>
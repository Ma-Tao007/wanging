<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

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
					    	<h1 style="text-align: center;">修改学生信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/student?method=edit" id="editfrom" method="post" onsubmit="return submit()">
							  <div class="form-group">
							    <label class="col-sm-2 control-label">学号</label>
							    <div class="col-sm-10">
							      <input readonly="readonly"  class="form-control" id="sno" name="sno" placeholder="" value="${student.sno}">
							    <input hidden name='password' value='${student.password }'>
							    </div>
							  </div>
							  <div class="form-group">
							    <label  class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input type="text" required="required" class="form-control" id="sname" name="sname" placeholder="请输入姓名" value="${student.sname}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label  class="col-sm-2 control-label">性别</label>
							    <div class="col-sm-10">
							      <input type="text" required="required" class="form-control" id="ssex" name="ssex" placeholder="请输入性别" value="${student.ssex}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label  class="col-sm-2 control-label">年龄</label>
							    <div class="col-sm-10">
							      <input type="number" required="required" class="form-control" id="sage" name="sage" placeholder="请输入年龄" value="${student.sage}">
							    </div>
							  </div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">专业</label>
								<div class="col-sm-10">
									<input type="text" required="required" class="form-control" id="sdept" name="sdept" placeholder="请输入专业" value="${student.sdept}">
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
        if($("#sname").val()=="" || $("#sname").val()==null){
            alert("请输入姓名")
            return false
        }
        if($("#sdept").val()=="" || $("#sdept").val()==null){
            alert("请输入专业")
            return false
        }
        if($("#sage").val()=="" || $("#sage").val()==null){
            alert("请输入年龄")
            return false
        }
        if($("#ssex").val()=="" || $("#ssex").val()==null){
            alert("请输入性别")
            return false
        }
        return true
    }
	</script>
</html>
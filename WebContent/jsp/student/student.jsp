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
        <jsp:include page="../stdmenu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">预警情况</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <div style="text-align: center;font-size:40px;height: 300px;line-height: 300px">${(item.nsum<3*item.sum/4)?((item.nsum<item.sum/2)?((item.nsum<item.sum/4)?"正常":"红色"):"延长修读"):"建议退学"}</div>
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
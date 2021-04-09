<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/student?method=getAll">学生管理</a></li>
        <li><a href="${pageContext.request.contextPath}/grade?method=getAll">成绩管理</a></li>
        <li><a href="${pageContext.request.contextPath}/warn?method=getAll">预警信息查看</a></li>
        <li><a href="${pageContext.request.contextPath}/user?method=logout">退出系统</a></li>
    </ul>
</div>
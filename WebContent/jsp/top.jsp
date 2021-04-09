<%@ page import="com.po.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.po.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer type =(Integer)request.getSession().getAttribute("type");
    if(type==1){
        User user = (User)request.getSession().getAttribute("userinfo");
        request.setAttribute("name",user.getUsername());
    }else{
        Student stu = (Student)request.getSession().getAttribute("userinfo");
        request.setAttribute("name",stu.getSname());
    }

%>
<!-- 顶栏 -->
<div class="container" id="top">
    <div class="row">
        <div class="col-md-12">
            <!--加入导航条标题-->
            <div class="navbar navbar-default" role="navigation">
                　<div class="navbar-header">
                　    <a href="#" class="navbar-brand">学业预警管理系统</a>
                　</div>
                <form action="##" class="navbar-form navbar-right" rol="search">
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" style="margin-right: 20px; ">
                            <%--登录用户名--%>
                            ${name}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                            <li role="presentation">
                                <a role="menuitem" tabindex="-1" href="user?method=logout">

                                    注销
                                </a>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

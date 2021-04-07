<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8">
    <title>学业预警管理系统</title>
<link rel="stylesheet" th:href="@{/css/style.css}">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>
    <div class="content">
        <div class="form sign-in">
       		<form class="form-horizontal" role="form" id="from1" onsubmit="return login()" method="post">
	            <h2>欢迎来到学业预警管理系统</h2>
	            <label>
	                <span>用户名</span>
	                <input class='input' type="text" id="username" name='username' />
	            </label>
	            <label>
	                <span>密码</span>
	                <input class='input' type="password" id="password" name='password' />
	            </label>
                <label>
                    <span>类型</span>
                    <select id="type" >
                        <option value="0">学生</option>
                        <option value="1">教师</option>
                    </select>
                </label>
	            <button type="submit" class="submit" >登 录</button>
            </form>
        </div>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h2>学业预警管理系统</h2>
                    <p>欢迎您</p>
                </div>
            </div>
        </div>
        <input hidden id='contextPath' value='${pageContext.request.contextPath}'>
    </div>
</body>
<SCRIPT>
    var contextPath = $("#contextPath").val()
    function login() {
        if ($("#username").val() == '' || $("#password").val() == '') {
            alert("请输入用户名和密码")
            return false
        }
        $.ajax({
            url:"user?method=login",
            method:'post',
            data:{'username':$("#username").val(),'password':$("#password").val(),'type':$("#type").val()},
            success:function(res){
                if(res=='验证成功'){
                    //登陆成功跳转
                    alert(res)
                    window.location = "student?method=getAll";
                }else{
                    alert(res)
                }
            },
            error:function (err) {
                console.log(err)
            }
        })

        return false
    }
</SCRIPT>
</html>

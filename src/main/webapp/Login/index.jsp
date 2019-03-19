<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/12
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<html>
<title>Login</title>
<link rel="icon" type="image/png" href="${ctx}/favicon.ico">
<style type="text/css">
    body {
        background: url("${ctx}/src/img/4.png");
        animation-name: myfirst;
        animation-duration: 12s;
        /*变换时间*/
        animation-delay: 1s;
        /*动画开始时间*/
        animation-iteration-count: infinite;
        /*下一周期循环播放*/
        animation-play-state: running;
        /*动画开始运行*/
    }

    @keyframes myfirst {
        0% {
            background: url("${ctx}/src/img/4.png");
        }

        34% {
            background: url("${ctx}/src/img/1.png");
        }

        67% {
            background: url("${ctx}/src/img/1.jpg");
        }

        100% {
            background: url("${ctx}/src/img/4.png");
        }
    }

    .form {
        background: rgba(255,255,255,0.4);
        width: 400px;
        margin: 20% auto;
        border-radius: 5%;
    }
    /*阴影*/
    .fa {
        display: inline-block;
        top: 27px;
        left: 6px;
        position: relative;
        color: #ccc;
    }

    input[type="text"], input[type="password"] {
        padding-left: 26px;
    }

    .checkbox {
        padding-left: 21px;
    }

    @font-face {
        font-family: MyFont;
        src: url(${ctx}/src/fonts/PlayfairDisplay-BoldItalic.ttf)
    }
    .errorMessage{
        color: red;
    }
</style>
<%-- 导入jquery --%>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<%-- 导入bootstrap --%>
<link href="${ctx}/src/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
<script src="https://cdn.bootcss.com/axios/0.18.0/axios.min.js"></script>
</head>
<body>
<div class="container">
    <div class="form row col-lg-offset-4">
        <form class="form-horizontal col-lg-offset-2" id="login_form" action="">
            <h3 class="form-title" style="font-family: MyFont; font-size:30px;">LOGIN</h3>
            <div class="col-lg-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input type="text" class="form-control required" id="Username" placeholder="请输入用户名"></input>
                    <label class="errorMessage" id="UserNameValid"></label>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input type="password" class="form-control required" id="Password" placeholder="请输入密码"></input>
                    <label class="errorMessage" id="PasswordValid"></label>
                </div>
                <div class="form-group">
                    <div id="v_container"
                         style="width: 125px; height: 30px; float: left; margin-top: 5px;">
                    </div>
                    <div class="col-md-6">
                        <input type="text" name="random" class="form-control"
                               id="code_input" placeholder="请输入验证码" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-5">
                        <label id="lab0"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="checkbox">
                        <input type="checkbox" name="remember" value="1" />记住我
                    </label>
                </div>
                <div class="form-group col-lg-offset-9">
                    <button class="btn btn-success pull-right" id="button_id">登录</button>
                </div>
                <div class="row">
                    <label id="hint" class="col-sm-12 text-center text-success"></label>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="${ctx}/src/js/gVerify.js" type="text/javascript"></script>
<script type="text/javascript">
    $("#button_id").click(function () {
        var res = verifyCode.validate(document.getElementById("code_input").value);
        $("#UserNameValid").text("");
        $("#PasswordValid").text("");
        if (!res) {
            alert("验证码输入错误");
            return false;
        } else {
            $("#button_id").attr('disabled', false);
            axios
                .post('${ctx}/Login/LoginServlet', {
                    name: $("#Username").val(),
                    password: $("#Password").val()
                })
                .then(function (response) {
                    if (response.data=="NameError"){
                        // alert("用户名错误");
                        $("#UserNameValid").text("用户名不存在");
                    }
                    if (response.data=="PasswordError"){
                        // alert("密码错误");
                        $("#PasswordValid").text("密码错误");
                    }
                    if (response.data=="success"){
                        alert("登录成功，欢迎光临");
                        //页面跳转
                        $(location).attr('href', 'http://www.cerambycidae.org.cn/');
                    }
                })
                .catch(function (error) {

                    alert(error)
                });
            return false;
        }
    })
    $(function () {
        $("#btn").click(function () {
            //验证
            var res = verifyCode.validate(document.getElementById("code_input").value);
            //获取验证码
            var v_code = new GVerify("v_container").options.code.toLowerCase();
        });
        $("#code_input").blur(function () {
            //验证
            var res = verifyCode.validate(document.getElementById("code_input").value);
            if (!res) {
                $("#lab0").css("color","red");
                $("#lab0").text("验证错误");
            } else {
                $("#lab0").css("color","black");
                $("#lab0").text("验证正确");
            }
        });
    });
    //调用js方法
    var verifyCode = new GVerify("v_container");
</script>
</body>
</html>
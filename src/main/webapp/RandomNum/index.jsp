<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>随机数</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.min.js"></script>
    <%-- 导入bootstrap --%>
    <link href="${ctx}/src/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div id="qm_con_body"><div id="mailContentContainer" class="qmbox qm_con_body_content qqmail_webmail_only" style="">
    <style type="text/css">
        .qmbox .link:link, .qmbox .link:active, .qmbox .link:visited {
            color:#2672ec !important;
            text-decoration:none !important;
        }

        .qmbox .link:hover {
            color:#4284ee !important;
            text-decoration:none !important;
        }
    </style>
    <br/>
    <br/>
    <table dir="ltr" id="table" style="margin: auto">
        <tr><td id="i2" style="padding:0; font-family:'Microsoft Yahei', Verdana, Simsun, sans-serif; font-size:41px; color:#2672ec;">安全代码</td></tr>
        <tr><td id="i4" style="padding:0; padding-top:25px; font-family:'Microsoft Yahei', Verdana, Simsun, sans-serif; font-size:14px; color:#2a2a2a;">
            安全代码：
            <span style="font-family:'Microsoft Yahei', Verdana, Simsun, sans-serif; font-size:14px; font-weight:bold; color:#2a2a2a;"><span id="random"     style="border-bottom:1px dashed #ccc;z-index:1" t="7" onclick="return false;" data="${random.random}">${random.random}</span></span>
<%--            <label id="random"></label>--%>
        </td>
        </tr>
        <tr>
            <td>
                <br/>
                <button value="获取验证码" class="btn btn-success pull-left" id="submit">获取验证码</button>
            </td>
        </tr>
    </table>

    <script>
        $("#submit").click(function(){
            axios.get('${ctx}/RandomNum/RandomServlet')
                .then(function (response) {
                    //局部刷新动态组件
                    alert(response.data)
                    $("#table").load(location.href+"#table");
                });
        });
    </script>
    <style type="text/css">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style></div></div>
</body>
</html>
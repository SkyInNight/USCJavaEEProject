<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学生数据库信息</title>
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${ctx}/src/src/assets/i/favicon.png">
    <script src="${ctx}/src/src/assets/js/echarts.min.js"></script>
    <link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/src/src/assets/css/app.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.min.js"></script>
</head>
<body data-type="widgets">
    <script src="${ctx}/src/src/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 内容区域 -->
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-body  am-fr">

                            <div class="am-u-sm-12" id="table">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                    <tr>
                                        <th>文章名称</th>
                                        <th>文章类别</th>
                                        <th>文章作者</th>
                                        <th>文章链接</th>
                                        <th>创建时间</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach items="${csdns }" var="csdn">
                                        <tr class="gradeX">
                                            <td>${csdn.article_title}</td>
                                            <td>${csdn.article_type}</td>
                                            <td>${csdn.nick_name}</td>
                                            <td>${csdn.article_link}</td>
                                            <td>${csdn.created_time}</td>
                                        </tr>
                                     </c:forEach>
                                    <!-- more data -->
                                    </tbody>
                                </table>
                            </div>
                            <div class="am-u-lg-12 am-cf">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script tpye="text/javascript">
        $(function () {
            axios.get('${ctx}/MongoDB/CSDNServlet')
                .then(function (response) {
                    //局部刷新动态组件
                    $("#table").load(location.href+" #table");
                });
        });
    </script>
    <script src="https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
    <script src="${ctx}/src/src/assets/js/app.js"></script>
</body>
</html>
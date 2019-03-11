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
    <link rel="icon" type="image/png" href="${ctx}/src/assets/i/favicon.png">
    <script src="${ctx}/src/assets/js/echarts.min.js"></script>
    <link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/src/assets/css/app.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/axios/0.18.0/axios.min.js"></script>
</head>
<body data-type="widgets">
    <script src="${ctx}/src/assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 内容区域 -->
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">学生信息</div>
                        </div>
                        <div class="widget-body  am-fr">
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                                <div class="am-form-group tpl-table-list-select">
                                    <select data-am-selected="{btnSize: 'sm'}" id="option">
                                        <%--<option value="option1">所有查询</option>--%>
                                        <option value="option2">姓名查询</option>
                                        <option value="option3">年龄查询</option>
                                        <option value="option4">专业查询</option>
                                    </select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field ">
                                    <span class="am-input-group-btn" id = "input">
                                            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button" id="find"></button>
                                    </span>
                                </div>
                            </div>

                            <div class="am-u-sm-12" id="table">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>姓名</th>
                                        <th>年龄</th>
                                        <th>性别</th>
                                        <th>专业</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                     <c:forEach items="${students }" var="student">
                                        <tr class="gradeX">
                                            <td>${student.id}</td>
                                            <td>${student.name}</td>
                                            <td>${student.age}</td>
                                            <td>${student.gender}</td>
                                            <td>${student.major}</td>
                                            <td>
                                                <div class="tpl-table-black-operation">
                                                    <a href="javascript:;" class="tpl-table-black-operation-del" onclick="deleteStudent(${student.id})">
                                                        <i class="am-icon-trash"></i> 删除
                                                    </a>
                                                </div>
                                            </td>
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
            axios.get('${ctx}/DataBaseStudent/ShowStudentDataBase')
                .then(function (response) {
                    //局部刷新动态组件
                    $("#table").load(location.href+" #table");
                });
        });
        $("#find").click(function(){
            var option = $("#option").val();
            var value = '';
            // if (option == "option1"){
            //     value = 'name='+ $("input").val() + '&major='+$("input").val();
            // }
            if (option == "option2"){
                value = 'name='+ $("input").val();
            }
            if (option == "option3"){
                value = 'age='+ $("input").val();
            }
            if (option == "option4"){
                value = 'major='+ $("input").val();
            }
            axios.get('${ctx}/DataBaseStudent/FindStudentDataBase?'+value)
                .then(function (response) {
                    //局部刷新动态组件
                    $("#table").load(location.href+" #table");
                });
        });
        deleteStudent = function (id) {
            axios.get('${ctx}/DataBaseStudent/DeleteStudentDataBaseServlet?id='+id)
                .then(function (response) {
                    //局部刷新动态组件
                    $("#table").load(location.href+" #table");
                });
        }
    </script>
    <script src="https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js"></script>
    <script src="${ctx}/src/assets/js/app.js"></script>
</body>
</html>
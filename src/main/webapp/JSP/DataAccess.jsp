<%--
  Created by IntelliJ IDEA.
  User: NEWSTART
  Date: 2019/3/15
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.usc.jspdemo.DataBaseOperator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="com.com.usc.pojo.*" %>
<%--处理编码问题 --%>
<%request.setCharacterEncoding("UTF-8");%>
<%--使用JavaBean --%>
<jsp:useBean id="student" scope="page" class="com.com.usc.pojo.Student"/>
<jsp:setProperty property="*" name="student"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    String name = "";
    String id = "";
    String team = "";
//获得操作类型参数
    String op = request.getParameter("op");
    int method = Integer.parseInt(op);
    switch(method){
        case 0:
            DataBaseOperator.getInstance().insert(student);
            break;
        case 1:
            DataBaseOperator.getInstance().delete(request.getParameter("id"));
            break;
        case 2:
            DataBaseOperator.getInstance().update(student);
            break;
        default:
            name = request.getParameter("name");
            id = request.getParameter("id");
            team = request.getParameter("team");
    }
    Set<Student> sts=DataBaseOperator.getInstance().searchStudents(id, name, team);
    Iterator<Student> it = sts.iterator();
    if(method==4){
%>
<form action="/JSP/DataAccess.jsp?op=2" method='post' target="workspace">
    <%
        while(it.hasNext()){
            Student st = it.next();
            Map<Integer,String> teams = DataBaseOperator.getInstance().searchTeams("", "");
            Set<Integer> keys=teams.keySet();
            Iterator<Integer> it1=keys.iterator();%>
    学号:<input type="text" name="id" value="<%=st.getId()%>"><br>
    姓名:<input type="text" name="name" value="<%=st.getName()%>"><br>
    年龄:<input type="text" name="age" value="<%=st.getAge()%>"><br>
    性别:<input type="text" name="gender" value="<%=st.getGender()%>"><br>
    班级:<select name="team">
    <%
        while(it1.hasNext()){
            int value = it1.next().intValue();
            String selected = "";
            if(value == st.getTeam())
                selected= "selected='selected'";
    %>
    <option value=<%=value %> <%=selected %>><%=value %></option>
    <% }%>
</select>
    专业:<input type="text" name="major" value="<%=st.getMajor() %>"><br>
    <%}%>
    <input type="submit" name="modify" value="修改"><br>
    <a href="/JSP/DataAccess.jsp?op=3">返回查询页面</a>
</form>
<%
}
else
{
%>
<table frame="border" bordercolor="black" style="width:600px;">
    <tr>
        <td style="border:1px solid black;">学号</td>
        <td style="border:1px solid black;">姓名</td>
        <td style="border:1px solid black;">年龄</td>
        <td style="border:1px solid black;">性别</td>
        <td style="border:1px solid black;">班级</td>
        <td style="border:1px solid black;">研究方向</td>
        <td style="border:1px solid black;">操作</td>
    </tr>
    <%
        while(it.hasNext()){
            Student st = it.next();
    %>
    <tr>
        <td style="border:1px solid black;"><%=st.getId() %></td>
        <td style="border:1px solid black;"><%=st.getName() %></td>
        <td style="border:1px solid black;"><%=st.getAge() %></td>
        <td style="border:1px solid black;"><%=st.getGender() %></td>
        <td style="border:1px solid black;"><%=st.getTeam() %></td>
        <td style="border:1px solid black;"><%=st.getMajor() %></td>
        <td style="border:1px solid black;">
            <a href="DataAccess.jsp?op=1&id=<%=st.getId() %>">删除</a>
            &nbsp&nbsp&nbsp&nbsp
            <a href="DataAccess.jsp?op=4&id=<%=st.getId() %>">修改</a>
        </td>
    </tr>
    <%} %>
</table>
<%} %>
</body>
</html>

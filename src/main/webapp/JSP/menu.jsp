<%--
  Created by IntelliJ IDEA.
  User: NEWSTART
  Date: 2019/3/15
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.usc.jspdemo.DataBaseOperator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<%
    Map<Integer,String> teams = DataBaseOperator.getInstance().searchTeams("", "");
    Set<Integer> keys = teams.keySet();
    Iterator<Integer> it1= keys.iterator();
    Iterator<Integer> it2 = keys.iterator();

%>
<body>
访问数据库:<br>
<table frame="border" bordercolor="black" style="width: 650px;">
    <tr valign="top">
        <td style="border: 1px solid black;">
            <form action="/JSP/DataAccess.jsp?op=3" method="post">
                查询操作:<br>
                学号:<input type="text" name="id"><br>
                姓名:<input type="text" name="name"><br>
                班级:<select name="team">
                <option value="">全部</option>
                <%while(it1.hasNext()){
                    int value = it1.next().intValue();
                %>
                <option value=<%=value %>><%=value %></option>
                <%} %>
            </select>
                <input type="submit" name="search" value="查询" align="middle">
            </form>
        </td>
        <td style="width: 431px; border:1px solid black;">
            <form action="/JSP/DataAccess.jsp?op=0" method="post" target="workspace">
                添加操作:<br>
                学号:<input type="text" name="id">
                姓名:<input type="text" name="name"><br>
                年龄:<input type="text" name="age">
                性别:<input type="text" name="gender"><br>
                班级:<select name="team">
                <%while(it2.hasNext()){
                    int value = it2.next().intValue();
                %>
                <option value=<%=value %>><%=value %></option>
                <%} %>
            </select>
                专业:<input type="text" name="major"><br>
                <input type="submit" name="add" value="添加">
            </form>
        </td>
    </tr>
</table>
</body>
</html>

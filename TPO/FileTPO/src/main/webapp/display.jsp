<%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 01/04/2023
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select an action</title>
</head>
<body>
<%
    if(session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>
WELCOME ${username}<br><br>
CHOOOOSEEE AN ACTION FIRST!!!!!!!!!!!!!!!!!!!<br><br>
<a href="createFile.jsp" >click to create a file</a><br>
<a href="read.jsp">click to read a file</a><br>
<a href="update.jsp">click to update a file</a><br>
<a href="../../../../WebApplication/src/main/webapp/delete.jsp">click to delete a file</a><br>
<a href="list.jsp">click to list files</a><br>
<br><br>
<form action="Logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>

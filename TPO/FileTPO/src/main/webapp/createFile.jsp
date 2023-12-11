<%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 05/04/2023
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating file....</title>
</head>
<body>
<%
    if(session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>
<form action=CreateFile>
    Enter fileName :  <input type="text" name="cfile" ><br>
        <input type="hidden" name="creator" value="${username}">
    <input type="submit" value="create">
</form>
<form action="Logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>

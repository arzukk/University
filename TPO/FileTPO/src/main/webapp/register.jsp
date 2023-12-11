<%@ page import="java.util.Scanner" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.io.IOException" %>
<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 10/04/2023
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register here</title>
</head>
<body>
<form action="register2.jsp" method="post">
    Insert username : <input type="text" name="rname"><br>
    Insert password : <input type ="password" name="rpass"><br>
    <input type="submit" value="register">
</form>
</body>
</html>

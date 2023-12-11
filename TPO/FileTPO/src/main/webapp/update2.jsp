<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.FileTPO.Ffile" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.attribute.BasicFileAttributes" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<h1>Insert the file content</h1>
<body>


    <%
        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
    %>

    <form action="updateFile.jsp" method="POST">
        <input type="hidden" name="fileName" value="<%= request.getParameter("fileName") %>">
        <input type="text" name="content"><br>
        <input type="submit" value="submit">
    </form>



    <form action="Logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>

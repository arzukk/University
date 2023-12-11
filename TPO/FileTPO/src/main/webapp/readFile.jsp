<%@ page import="java.io.*" %>

<%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 05/04/2023
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose to file you want to display</title>
</head>
<body>
<%
    if(session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>
<br>
<br>
<%
    String fileName = request.getParameter("fileName");
    String filePath = "/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/" + fileName;
    File file = new File(filePath);
    PrintWriter out2 = response.getWriter();
    System.out.println(fileName+ " IS BEING READ");

    if (file.exists() && file.isFile() && fileName.equals("passwords.txt") == false) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLineSkip = true;
            while ((line = reader.readLine()) != null) {
                if (firstLineSkip) {
                    firstLineSkip = false;
                    continue;
                }
                out2.println(line + "<br>");
            }
        } catch (IOException e) {
            out2.println("Error while reading file: " + e.getMessage());
        }
    } else {
        out2.println("You dont have file permission " + fileName);
    }
%>
<form action="formDisplay.jsp" method="POST">
    <input type="submit" value="return menu">
</form>

</body>
</html>

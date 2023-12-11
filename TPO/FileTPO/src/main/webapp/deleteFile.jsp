<%@ page import="java.io.File" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %><%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 05/04/2023
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose the file you want to delete</title>
</head>

<body>
<%
    String fileName = request.getParameter("fileName");
    String username = (String) session.getAttribute("username");


    String filePath = "/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/" + fileName;
    PrintWriter out2 = response.getWriter();

    File file = new File(filePath);
    BufferedReader reader2 = new BufferedReader(new FileReader(file));
    String owner = reader2.readLine();
//    System.out.println(owner + " " + "owner");
//    System.out.println(username +  " " + "username");
    if (owner.equals(username)&& !fileName.equals("passwords.txt")) {
    try{
        file.delete();
        out2.println("File deleted: " + fileName);}
    catch(Exception e){
        e.printStackTrace();
    }}
    else{
        out2.println("Only owner can delete the file");
    }
%>

    <form action="formDisplay.jsp" method="POST">
    <input type="submit" value="return menu">
    </form>

</body>
</html>

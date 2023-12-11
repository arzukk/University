<%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 05/04/2023
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page import="java.io.*" %>

<%
    String fileName = request.getParameter("fileName");
    String content = request.getParameter("content");
    String username = request.getParameter("username");


    String filePath = "/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/" + fileName;
    PrintWriter out2 = response.getWriter();
    File file = new File(filePath);
    BufferedReader reader2 = new BufferedReader(new FileReader(file));
    String owner = reader2.readLine();
    System.out.println(owner + " " + "owner");
    System.out.println(username +  " " + "username");
    if (owner.equals(username) && !fileName.equals("passwords.txt")) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            sb.append(content);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(sb.toString());
            } catch (IOException e) {
                out2.println("Error writing to file: " + e.getMessage());
            }
        } catch (IOException e) {
            out2.println("Error reading file: " + e.getMessage());
        }
        out2.println("File updated successfully: " + fileName);
    }
    else{
        out2.println("Only owner can update the file");
    }
%>
<form action="formDisplay.jsp" method="POST">
    <input type="submit" value="return menu">
</form>
<body>

</body>
</html>

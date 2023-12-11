<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.FileTPO.Ffile" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.attribute.BasicFileAttributes" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<h1>List of files</h1>
<body>
<table>
    <thead>
    <tr>
        <th>File name</th>
        <th>Creator</th>
        <th>Creation date</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
    %>
    <%
        File directory = new File("/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files");
        File[] files = directory.listFiles();
        ArrayList<Ffile> txtFiles = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String filename = file.getName();
                    BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                    Date creationDate = new Date(attributes.creationTime().toMillis());

                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String owner = reader.readLine();
                        session.setAttribute("owner", owner);
                        Ffile ffile = new Ffile(filename, owner, creationDate);
                        txtFiles.add(ffile);

                    } catch (IOException e) {
                        System.out .println("Error reading file: " + e.getMessage());
                    }
                }
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (txtFiles != null) {
            for (Ffile txtFile : txtFiles) {
                System.out.println(txtFile +  " "+ "txtFile");
    %>
    <tr>
        <td><a href="update2.jsp?fileName=<%= txtFile.getName() %>"><%= txtFile.getName() %></a></td>
        <td><%= txtFile.getCreator() %></td>
        <td><%= sdf.format(txtFile.getDate()) %></td>
    </tr>
    <% }
    } %>
    </tbody>
</table>
<form action="Logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>

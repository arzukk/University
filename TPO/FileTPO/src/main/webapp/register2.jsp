<%@ page import="java.util.Scanner" %>
<%@ page import="java.nio.file.Path" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.io.*" %><%--
  Created by IntelliJ IDEA.
  User: arzukilic
  Date: 10/04/2023
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing...</title>
</head>
<body>


<%
    String username = request.getParameter("rname");
    String password = request.getParameter("rpass");
    PrintWriter out2 = response.getWriter();
    boolean wroteToFile = false;

    if (username != null && password != null) {
        String filePath = "/Users/arzukilic/IdeaProjects/FileTPO/src/main/java/com/example/FileTPO/Files/passwords.txt";
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount);

                if (lineCount == 1) {
                    continue;
                }

                String[] sArray = line.split(",");

                if (username.equals(sArray[0])) {
                    out2.println("this username is taken");
                    wroteToFile = true;
                    break;
                } else if (!wroteToFile && password.length() <= 3) {
                    out2.println("this password is too short");
                    wroteToFile = true;
                }
            }

            if (!wroteToFile) {
                try (FileWriter fw = new FileWriter(file, true)) {
                    String userData = username + "," + password;
                    fw.write(userData + "\n");
                    wroteToFile = true;

                    if (wroteToFile) {
                        out2.println("registered successfully");
                        response.sendRedirect("login.jsp");
                    } else {
                        out2.println("try again");
                    }
                } catch (IOException e) {
                    out2.println("error while writing to file " + e.getMessage());
                }
            }
        } catch (IOException e) {
            out2.println("error while reading file " + e.getMessage());
        }
    }
%>


</body>
</html>

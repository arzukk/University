<!DOCTYPE html>
<html>
<body>
<h1>Web Application</h1>
<form action="Controller" method="post">
    Enter the first number: <input type="text" name="num1"><br>
    Enter the second number: <input type="text" name="num2"><br>
    <input type="submit" value="Add (POST)">
</form>
<br> <br><br>
<form action="Controller" method="get">
    Enter the first number: <input type="text" name="num1"><br>
    Enter the second number: <input type="text" name="num2"><br>
    <input type="submit" value="Add (GET)">
</form>
<%
    if (session.getAttribute("add")!=null) {
        out.println("Sum is : "+session.getAttribute("add"));
        session.removeAttribute("add");
    }

%>
</body>
</html>

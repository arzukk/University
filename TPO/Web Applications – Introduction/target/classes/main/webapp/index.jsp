<!DOCTYPE html>
<html>
<body>
<h1>Web Application</h1>
<form action="HelloServlet" method="post">
    Enter the first number: <input type="text" name="num1"><br>
    Enter the second number: <input type="text" name="num2"><br>
    <input type="submit" value="Add (POST)">
</form>
<br> <br><br>
<form action="HelloServlet" method="get">
    Enter the first number: <input type="text" name="num1"><br>
    Enter the second number: <input type="text" name="num2"><br>
    <input type="submit" value="Add (GET)">
</form>
</body>
</html>

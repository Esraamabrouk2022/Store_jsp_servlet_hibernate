<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<% if (request.getParameter("error") != null && request.getParameter("error").equals("true")) { %>
<p style="color: red;">Invalid username or password. Please try again.</p>
<% } %>
<form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br/><br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br/><br/>
    <input type="submit" value="Login">
</form>
</body>
</html>

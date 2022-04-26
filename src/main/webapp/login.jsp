<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("profile.jsp");
        }
        response.sendRedirect("login.jsp");
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Please login to continue...</h1>

<form method="POST">
    <label for="login">User Login</label>
    <input name="login" id="login" type="text">
    <label for="pass">Password</label>
    <input name="password" id="pass" type="password">
    <button type="submit">Submit</button>
</form>

</body>
</html>
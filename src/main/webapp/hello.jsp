<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head
><title></title>
</head>

<body>

<h1>Hi there, what's your name?</h1>
<form method="post" action="Hello">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name">
    <button type="submit">Submit</button>
</form>

<c:if test = "${name != null}">
    <p>Hello there, ${name}</p>
</c:if>

</body>
</html>
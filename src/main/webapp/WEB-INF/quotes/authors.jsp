<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>

<c:forEach var="author" items="${authors}">
    <p>${author.author_name}</p>
</c:forEach>

</body>
</html>
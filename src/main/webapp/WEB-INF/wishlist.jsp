<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>

<c:forEach var="ad" items="${sessionScope['wishlist']}">
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
</c:forEach>

<form action="wishlist" method="POST">
    <label for="clear"></label>
    <input type="hidden" name="clear" id="clear">
    <button type="submit">Clear</button>
</form>

</body>
</html>
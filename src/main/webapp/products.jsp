<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductsServlet</title>
</head>
<body>
<form method="post" action="Products">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name">
    <label for="price">Price:</label>
    <input type="text" name="price" id="price">
    <input type="submit">
</form>
<c:forEach var="product" items="${products}">
    <div class="product">
        <h2>${product.name}</h2>
        <p>Price: $ ${product.price}</p>
    </div>
</c:forEach>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Hello, ${user}</h1>
        <h1>Viewing your profile.</h1>
    </div>

    <br>

    <%--<h2>${"wishlist"}</h2>--%>
    <c:if test="${wishlist != null}">
        <h3>Wishlist:</h3>
        <ul>
            <c:forEach var="i" items="${wishlist}">
                <li>${i}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form action="wishlist" method="POST">
        <label for="wishlist">Add to wishlist</label>
        <input id="wishlist" name="wishlist" type="text">
        <button type="submit">Add</button>
    </form>
<%--    <form action="clear" method="POST">--%>
<%--        <label for="clear">Clear wishlist</label>--%>
<%--        <input type="text" id="clear" name="clear">--%>
<%--        <button type="submit">Clear</button>--%>
<%--    </form>--%>

    <br>

    <form action="logout" method="POST">
        <input type="hidden" name="logout">
        <button>Logout</button>
    </form>


</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>

            <form action="wishlist" method="POST">
                <label for="wishlist">Add to wishlist</label>
                <input id="wishlist" name="title" type="hidden" value="${ad.title}">
                <input type="hidden" name="description" value="${ad.description}">
                <button type="submit">Add</button>
            </form>

        </div>
    </c:forEach>
</div>

</body>
</html>

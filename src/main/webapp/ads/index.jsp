<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/ads/index.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp" />

<h1>Ads Index</h1>

<c:forEach var="i" items="${list}">
    <h3>${i.title}</h3>
    <p>${i.description}</p>
</c:forEach>

</body>
</html>
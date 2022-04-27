<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--Create a file called foods.jsp.--%>

<%--Add scriptlet tags and define an ArrayList of strings containing 10 foods.--%>

<%--Include JSTL in this JSP.--%>

<%--Add the needed JSTL to display each food in a list item. Use an ordered list. The food list should look something like this:--%>

<%--1. Hot Dogs--%>
<%--2. Pizza--%>
<%--3. Nachos--%>
<%--...--%>

<%--Underneath the existing unordered list of foods, use JSTL to display the list of foods again but only food strings longer than 6 characters should be displayed. This should not require a change to the data in the--%>
<%--scriptlet tags (use the string length condition in the test attribute of a JSTL c:if tag).--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--        REQUIRED =>         --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    List<String> foodList = new ArrayList<>();
    foodList.add("Hot Dog");
    foodList.add("Pizza");
    foodList.add("Nachos");
    foodList.add("Burger");
    foodList.add("Ice Cream");
    request.setAttribute("foods", foodList);
%>

<html>
<head>
    <title>Foods</title>
</head>
<body>

<ol>
    <c:forEach var="i" items="${foods}">
        <li>${i}</li>
    </c:forEach>
</ol>

<h2>Foods with more than 6 char:</h2>

<ul>
    <c:forEach var="i" items="${foods}">
        <c:if test="${i.length() > 6}">
            <li>${i}</li>
        </c:if>
    </c:forEach>
</ul>

</body>
</html>
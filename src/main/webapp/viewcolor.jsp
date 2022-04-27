<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Pick Color</title>
</head>
<body>

<h1>Enter Your Favorite Color!</h1>

<style>

    body {
        background-color: ${param.favColor};
    }

</style>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Guess</title>
</head>
<body>

<h1>Guessing Game</h1>

<form action="guess" method="POST">
    <fieldset>
        <legend>Guess a number between 1-3:</legend>

        <div>
            <input type="radio" id="1" name="guess" value="1"
                   checked>
            <label for="1">1</label>
        </div>
        <div>
            <input type="radio" id="2" name="guess" value="2">
            <label for="2">2</label>
        </div>
        <div>
            <input type="radio" id="3" name="guess" value="3">
            <label for="3">3</label>
        </div>

    <button type="submit">Submit</button>
    </fieldset>
</form>

</body>
</html>
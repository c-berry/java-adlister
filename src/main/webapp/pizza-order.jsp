<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Pizza Form</title>
</head>
<body>
<p>

<h1>Order a pizza!</h1>

<form method="POST">

    <label for="crust-type">Choose crust:</label>
    <select name="crust" id="crust-type">
        <option value="">Select your crust:</option>
        <option value="original">Original</option>
        <option value="thin">Thin</option>
        <option value="hand-tossed">Hand-tossed</option>
        <option value="deep-dish">Deep-dish</option>
    </select>

    <br>
    <br>

    <label for="sauce-type">Choose sauce:</label>
    <select name="sauce" id="sauce-type">
        <option value="">Select your sauce:</option>
        <option value="red">Red</option>
        <option value="white">White</option>
        <option value="none">None</option>
    </select>

    <br>
    <br>

    <label for="size">Choose size:</label>
    <select name="size" id="size">
        <option value="">Select your pizza size:</option>
        <option value="10">10"</option>
        <option value="12">12"</option>
        <option value="16">16"</option>
    </select>

    <br>
    <br>

    Choose toppings:
    <br>
    <input type="checkbox" id="topping1" name="topping1" value="pepperoni">
    <label for="topping1">Pepperoni</label><br>
    <input type="checkbox" id="topping2" name="topping2" value="mushrooms">
    <label for="topping2">Mushrooms</label><br>
    <input type="checkbox" id="topping3" name="topping3" value="onion">
    <label for="topping3">Onion</label>

    <br>
    <br>

    <label for="address">Deliver to:</label>
    <input type="text" id="address" name="address" placeholder="Enter delivery address">

    <br>
    <br>

    <button type="submit">Submit</button>
</form>

<c:if test="${crust != null}">
    <h3>Pizza order:</h3>
    <p>Crust: ${crust}</p>
    <p>Sauce: ${sauce}</p>
    <p>Size: ${size}</p>
</c:if>

<c:if test="${topping != null}">
    <p>Toppings:</p>
</c:if>

<ul>
    <c:forEach var="i" items="${topping}">
        <c:if test="${i != null}">
            <li>${i}</li>
        </c:if>
    </c:forEach>
</ul>

<c:if test="${d_address != null}">
    <p>Delivery address: ${d_address}</p>
</c:if>

</body>
</html>

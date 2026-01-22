<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Employee App Login</h2>

<c:if test="${error != null}">
    <p style="color:red">${error}</p>
</c:if>

<form action="/login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required /><br/><br/>

    <label>Password:</label>
    <input type="password" name="password" required /><br/><br/>

    <button type="submit">Login</button>
</form>

</body>
</html>

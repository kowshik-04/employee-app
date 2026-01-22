<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Employee Form</title>
</head>
<body>

<h2>
    <c:choose>
        <c:when test="${employee.id != null}">
            Edit Employee
        </c:when>
        <c:otherwise>
            Add Employee
        </c:otherwise>
    </c:choose>
</h2>

<form action="/employees/save" method="post">

    <input type="hidden" name="id" value="${employee.id}" />

    <label>Name:</label>
    <input type="text" name="name" value="${employee.name}" required /><br/><br/>

    <label>Department:</label>
    <input type="text" name="department" value="${employee.department}" required /><br/><br/>

    <label>Salary:</label>
    <input type="number" step="0.01" name="salary" value="${employee.salary}" required /><br/><br/>

    <button type="submit">Save</button>
</form>

<br/>
<a href="/employees">Back to Employee List</a>

</body>
</html>

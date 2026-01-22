<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>

<h2>Employee List</h2>

<a href="/employees/add">Add New Employee</a>
<br/><br/>

<table border="1" cellpadding="8">
    <tr>
        <th>Name</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${employees}" var="emp">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <a href="/employees/edit/${emp.id}">Edit</a> |
                <a href="/employees/delete/${emp.id}"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="/dashboard">Back to Dashboard</a>

</body>
</html>

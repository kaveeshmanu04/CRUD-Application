<%--
  Created by IntelliJ IDEA.
  User: KAVEESH
  Date: 4/2/2023
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
</head>
<body>
<h1>User List</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
                <a href="update?id=${user.id}">Edit</a>
                <a href="delete?id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="add.jsp">Add new user</a></p>


</body>
</html>

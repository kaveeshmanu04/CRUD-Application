<%--
  Created by IntelliJ IDEA.
  User: KAVEESH
  Date: 4/2/2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Update</title>
</head>
<body>
<h1>Edit User</h1>
<form method="post" action="update">
    <input type="hidden" name="id" value="${user.id}">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}">
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}">
    </div>
    <div>
        <button type="submit">Update</button>
        <button type="button" onclick="location.href='list.jsp'">Cancel</button>
    </div>
</form>

</body>
</html>

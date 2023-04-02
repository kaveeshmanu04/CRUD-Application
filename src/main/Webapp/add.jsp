<%--
  Created by IntelliJ IDEA.
  User: KAVEESH
  Date: 4/2/2023
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>
<form method="post" action="adduser">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
    </div>
    <div>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
    </div>
    <div>
        <button type="submit">Save</button>
        <button type="button" onclick="location.href='list.jsp'">Cancel</button>
    </div>
</form>


</body>
</html>

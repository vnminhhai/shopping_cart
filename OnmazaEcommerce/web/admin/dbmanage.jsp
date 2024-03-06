<%-- 
    Document   : dbmanage
    Created on : Feb 29, 2024, 1:19:03 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <p>
            <a href=".${applicationScope.appName}/manageAccount">Add or remove staff</a>
        </p>
        <p>
            <a href=".${applicationScope.appName}/checkOrder">Check orders</a>
        </p>
        <p>
            <a href=".${applicationScope.appName}/addItem">Add an item</a>
        </p>
        <p>
            <a href=".${applicationScope.appName}/addVariant">Add a variant</a>
        </p>
    </body>
</html>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title><spring:message code="form.userList.title"/></title>
</head>
<body>

<h3><spring:message code="form.userList.table.title"/></h3>
<table border="1">
    <tr>
        <th><spring:message code="form.userList.table.column.id.name"/></th>
        <th><spring:message code="form.userList.table.column.firstName.name"/></th>
        <th><spring:message code="form.userList.table.column.lastName.name"/></th>
    </tr>
    <c:forEach var="x" items="${userList}">
        <tr>
            <td>${x.id}</td>
            <td>${x.firstName}</td>
            <td>${x.lastName}</td>
        </tr>
    </c:forEach>
</table>

<hr/>

<a href="http://localhost:8080/mvc/adduser.form"><spring:message code="form.addUser.title"/></a>

</body>
</html>
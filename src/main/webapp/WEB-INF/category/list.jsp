<%--
  Created by IntelliJ IDEA.
  User: luan_prep_vn
  Date: 29/05/2024
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:set var="age" value="18"/>
<c:if test="${age >= 18}">
    <h1>Bạn đủ tuổi đăng nhập vào hệ thống</h1>
</c:if>

<c:choose>
    <c:when test="${age >= 18}">
        <h1>Bạn đủ tuổi đăng nhập vào hệ thống</h1>
    </c:when>
    <c:when test="${age >= 16}">
        <h1>Bạn chưa đủ tuổi đăng nhập vào hệ thống</h1>
    </c:when>
    <c:otherwise>
        <h1>Bạn chưa đủ tuổi đăng nhập vào hệ thống</h1>
    </c:otherwise>
</c:choose>

<fmt:setLocale value="en_US"/>
<fmt:formatNumber value="123456789" type="number"/>
<fmt:formatNumber value="123456789" type="currency"/>
</body>
</html>

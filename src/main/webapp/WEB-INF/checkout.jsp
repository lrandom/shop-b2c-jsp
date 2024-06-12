<%--
  Created by IntelliJ IDEA.
  User: luan_prep_vn
  Date: 12/06/2024
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/checkout">
    <input type="text" name="full_name" placeholder="Full Name"/>
    <input type="text" name="address" placeholder="Address"/>
    <input type="text" name="phone" placeholder="Phone"/>
    <textarea placeholder="Note" name="note"></textarea>
    <button>Checkout</button>
</form>
</body>
</html>

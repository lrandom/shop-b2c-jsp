<%--
  Created by IntelliJ IDEA.
  User: luan_prep_vn
  Date: 10/06/2024
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">

        <c:forEach var="product" items="${list}">
            <div class="col-4">
                <div class="card" style="width: 100%;margin-top: 50px">
                    <img src="${product.getPath()}" class="card-img-top" style="width: 100%;height: 400px" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${product.getName()}</h5>
                        <p class="card-text">
                            <fmt:formatNumber value="${product.getPrice()}" type="currency"/>
                        </p>
                        <a href="add-to-cart?id=${product.getId()}" class="btn btn-primary">Add To Cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
</body>
</html>

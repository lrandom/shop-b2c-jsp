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
        <h1>Giỏ hàng</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Xoá</th>
                <th scope="col">Hình ảnh</th>
                <th scope="col">SP</th>
                <th scope="col">Giá</th>
                <th scope="col">Số lượng</th>
                <th scope="col">Tổng</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="cartItem" items="${list}">
                <tr>
                    <th scope="row">
                        <a href="${pageContext.servletContext.contextPath}/cart?command=remove&productId=${cartItem.getProduct().getId()}">Xoá</a>
                    </th>
                    <td>
                        <img style="width: 80px;height: 50px" src="${cartItem.getProduct().getPath()}"/>
                    </td>
                    <td>
                            ${cartItem.getProduct().getName()}
                    </td>
                    <td>
                        <fmt:formatNumber value="${cartItem.getProduct().getPrice()}" type="currency"/>
                    </td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/cart?command=update-quantity&productId=${cartItem.getProduct().getId()}&quantity=-1"
                           style="text-decoration: none; color: black; font-size: 20px; font-weight: bold;"
                        >-</a>
                        <input type="number" value="${cartItem.getQuantity()}"/>
                        <a href="${pageContext.servletContext.contextPath}/cart?command=update-quantity&productId=${cartItem.getProduct().getId()}&quantity=1"
                           style="text-decoration: none; color: black; font-size: 20px; font-weight: bold;"
                        >+</a>
                    </td>

                    <td>
                        <fmt:formatNumber value="${cartItem.getProduct().getPrice() * cartItem.getQuantity()}"
                                          type="currency"/>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="row">
        <div class="col-6">
            <h4>Tổng tiền hàng: <fmt:formatNumber value="${subTotal}" type="currency"/></h4>
            <h4>Thuế: <fmt:formatNumber value="${tax}" type="currency"/></h4>
            <h4>Tổng tiền: <fmt:formatNumber value="${total}" type="currency"/></h4>
        </div>

        <div class="col-6">
            <a>Đặt hàng</a>
        </div>
    </div>
</div>
</body>
</html>

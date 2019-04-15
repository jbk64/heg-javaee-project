<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product detail</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../../ressources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../ressources/css/style.css">
</head>
<body>

<!-- Menu -->
<jsp:include page="menu.jsp"/>

<br>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h2>Your cart</h2>
        </div>
        <br>
        <div class="col-12">
            <c:choose>
            <c:when test="${shoppingCartContent.size() gt 0}">
            <table class="table table-bordered table-sm">
                <thead>
                <tr class="table-secondary">
                    <th scope="col">ID</th>
                    <th scope="col">Product</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="shoppingCartItem" items="${shoppingCartContent}">
                    <tr>
                        <td>${shoppingCartItem.key.id}</td>
                        <td>${shoppingCartItem.key.name}</td>
                        <td>${shoppingCartItem.key.price}</td>
                        <td>
                            ${shoppingCartItem.value}
                            <form action="${pageContext.request.contextPath}/addItem" method="post" class="button-form">
                                <input type="hidden" name="productId" value="${shoppingCartItem.key.id}">
                                <button type="submit" class="btn btn-sm btn-success">&plus;</button>
                            </form>
                            <form action="${pageContext.request.contextPath}/removeItem" method="post" class="button-form">
                                <input type="hidden" name="productId" value="${shoppingCartItem.key.id}">
                                <button type="submit" class="btn btn-sm btn-danger">&minus;</button>
                            </form>
                        </td>
                        <td>${shoppingCartItem.key.price * shoppingCartItem.value}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p>Your total: XXX</p>
            <br>
            <form action="${pageContext.request.contextPath}/checkout" method="post" class="button-form">
                <button type="submit" class="btn btn-success">Checkout</button>
            </form>
            </c:when>
            <c:otherwise>
            <p>Nothing here</p>
            </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

</body>
</html>

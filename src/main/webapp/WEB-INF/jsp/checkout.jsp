<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product detail</title>
    <link rel="stylesheet" type="text/css" href="../../ressources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../ressources/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>

<!-- Menu -->
<jsp:include page="menu.jsp"/>

<br>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>Your cart</h1>
        </div>
        <br>
        <div class="col-12">
            <table class="table table-bordered">
                <thead>
                <tr class="table-secondary">
                    <th scope="col">Product</th>
                    <th scope="col">Quantity</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${cartProducts}">
                    <tr>
                        <td>${product.name}</td>
                        <td>1</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>

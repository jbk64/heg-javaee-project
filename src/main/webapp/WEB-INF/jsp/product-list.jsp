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
            <h1>All products</h1>
        </div>
        <br>
        <c:forEach var="product" items="${products}">
            <div class="col-4">
                <div class="card">
                    <img src="https://dummyimage.com/300x200" class="card-img-top img-fluid" alt="Product image">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.description}</p>
                        <a href="${pageContext.request.contextPath}/product?id=${product.id}">Product page</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>

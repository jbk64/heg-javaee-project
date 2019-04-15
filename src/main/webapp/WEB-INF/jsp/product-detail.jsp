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
        <div class="col-12 col-md-6">
            <h2>${product.name}</h2>
            <p>${product.description}</p>
            <form action="${pageContext.request.contextPath}/addItem" method="post">
                <input type="hidden" name="productId" value="${product.id}" />
                <button type="submit" class="btn btn-success">Add to cart <i class="fas fa-shopping-cart"></i></button>
            </form>
        </div>
        <div class="col-12 col-md-6">
            <img src="https://dummyimage.com/450x300" class="img-fluid float-right" alt="">
        </div>
    </div>
</div>

</body>
</html>

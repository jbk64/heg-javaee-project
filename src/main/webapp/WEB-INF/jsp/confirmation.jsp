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
            <h2>Your order is confirmed</h2>
            <p>You will receive a confirmation email soon. Thank you for shopping with us.</p>
            <br>
            <a href="${pageContext.request.contextPath}/catalog">Back to shopping</a>
        </div>
        <br>
    </div>
</div>

</body>
</html>

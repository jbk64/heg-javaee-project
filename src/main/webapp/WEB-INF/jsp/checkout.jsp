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
            <h2>Checkout</h2>
            <br>
            <div class="row">
                <div class="col-6">
                    <h3>Payment</h3>
                    <form action="${pageContext.request.contextPath}/confirmation" method="get">
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" class="form-control" id="name" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <label for="cardNumber">Card number</label>
                            <input type="text" class="form-control" id="cardNumber" placeholder="Card number">
                        </div>
                        <div class="form-group">
                            <label for="expirationMonth">Expiration month</label>
                            <select class="form-control" id="expirationMonth">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="expirationYear">Expiration year</label>
                            <select class="form-control" id="expirationYear">
                                <option>21</option>
                                <option>22</option>
                                <option>23</option>
                                <option>24</option>
                                <option>25</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-success">Checkout</button>
                    </form>
                    <br>
                    <a href="${pageContext.request.contextPath}/catalog">Back to shopping</a>
                </div>
                <div class="col-6">
                    <h3>Your total</h3>
                    <p>${totalCost} CHF</p>
                </div>
            </div>
        </div>
        <br>
    </div>
</div>

</body>
</html>

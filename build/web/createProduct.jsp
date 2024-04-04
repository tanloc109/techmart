<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create new Product</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD' }">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
        
        <div class="container">
            <h1 class="mt-5">Input new product information:</h1>
            <form action="MainController">
                <div class="form-group">
                    <label for="productName">Product Name:</label>
                    <input type="text" class="form-control" id="productName" name="productName" required maxlength="20">
                </div>
                <div class="form-group">
                    <label for="image">Image:</label>
                    <input type="text" class="form-control" id="image" name="image" maxlength="50">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" required min="0">
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" min="0">
                </div>
                <div class="form-group">
                    <label for="memory">Memory:</label>
                    <input type="number" class="form-control" id="memory" name="memory" min="64" max="2048">
                </div>
                <div class="form-group">
                    <label for="category">Category:</label>
                    <input type="number" class="form-control" id="category" name="category" min="1" max="3" required>
                </div>
                <div class="form-group">
                    <label for="status">Status:</label>
                    <input type="number" class="form-control" id="status" name="status" min="0" max="1" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" name="action" value="CreateProduct">Create Product</button>
                    <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
            </form>
            <div class="text-danger">${requestScope.PRODUCT_ERROR.getError()}</div>
            <form action="MainController">
                <button type="submit" class="btn btn-primary" name="action" value="Home">Home</button>
            </form>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>

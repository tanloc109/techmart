<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <title>Product Management</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa;
                margin: 20px;
            }
            h1 {
                margin-bottom: 20px;
            }
            .container {
                margin-top: 20px;
            }
            .table-responsive {
                margin-top: 20px;
            }
            form {
                margin-bottom: 20px;
            }
            .abc{
                margin-left: 192px;
                margin-top: 36px;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <h1 class="text-center">Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>

        <div class="container">
            <form action="MainController">
                <div class="form-group row">
                    <label for="search" class="col-sm-3 col-form-label">Search By Product Name:</label>
                    <div class="col-sm-4">
                        <input type="text" name="search" id="search" class="form-control" value="${param.search}">
                    </div>
                    <div class="col-sm-2">
                        <input type="submit" name="action" value="SearchProduct" class="btn btn-primary">
                    </div>
                </div>
            </form>

            <form action="MainController">
                <div class="form-group row">
                    <label for="category" class="col-sm-2 col-form-label">Choose Category:</label>
                    <div class="col-sm-4">
                        <select name="category" id="category" class="form-control">
                            <c:forEach var="categoryInList" items="${requestScope.LIST_CATEGORY}">
                                <option value="${categoryInList}">${categoryInList}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-sm-2">
                        <input type="submit" name="action" value="SearchProductByCategory" class="btn btn-primary">
                    </div>
                </div>
            </form>

            <c:if test="${not empty requestScope.LIST_PRODUCT}">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th>No</th>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Memory</th>
                                <th>CategoryID</th>
                                <th>Status</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}">
                            <form action="MainController">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td><input type="text" name="productID" value="${product.productID}" readonly="" style="width: 90px;"/></td>
                                    <td><input type="text" name="productName" value="${product.productName}" style="min-width: 250px;"/></td>
                                    <td><input type="number" name="price" value="${product.price}" style="min-width: 250px;"/></td>
                                    <td><input type="number" name="quantity" value="${product.quantity}" style="width: 90px;"/></td>
                                    <td><input type="number" name="memory" value="${product.memory}"style="width: 90px;"/></td>
                                    <td><input type="number" name="category" value="${product.category}"style="width: 90px;"/></td>
                                    <td><input type="number" name="status" value="${product.status}" style="width: 90px;"/></td>
                                    <td>
                                        <input type="hidden" name="search" value="${param.search}">
                                        <input type="submit" name="action" value="UpdateProduct" class="btn btn-primary">
                                    </td>
                                    <td>
                                        <input type="submit" name="action" value="DeleteProduct" class="btn btn-danger">
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </c:if>
        </div>
        <h4 class="text-success abc">${requestScope.MESSAGE}</h4>
        <div class="container mt-5">
            <form action="MainController">
                <input type="submit" name="action" value="Create_New_Product" class="btn btn-success">
            </form>


            <form action="MainController" class="mt-5">
                <div class="form-group row">
                    <label for="priceStart" class="col-sm-2 col-form-label">Price Start:</label>
                    <div class="col-sm-2">
                        <input type="number" name="priceStart" id="priceStart" class="form-control" value="${param.priceStart}" min="0" required>
                    </div>
                    <label for="priceEnd" class="col-sm-2 col-form-label">Price End:</label>
                    <div class="col-sm-2">
                        <input type="number" name="priceEnd" id="priceEnd" class="form-control" value="${param.priceEnd}" required>
                    </div>
                    <div class="col-sm-2">
                        <input type="submit" name="action" value="ListProductsInRange" class="btn btn-primary">
                    </div>
                </div>
            </form>

            <c:if test="${not empty requestScope.LIST_IN_RANGE}">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th>No</th>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Memory</th>
                                <th>Category Name</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_IN_RANGE}">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${product.productID}</td>
                                    <td>${product.productName}</td>
                                    <td><fmt:formatNumber pattern="#,###">${product.price}</fmt:formatNumber> VND</td>
                                    <td>${product.quantity}</td>
                                    <td>${product.memory}</td>
                                    <td>${product.categoryName}</td>
                                    <td>${product.status}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <p>${requestScope.MESSAGE}</p>
            </c:if>
        </div>

        <div class="container text-center">
            <form action="MainController">
                <input type="submit" name="action" value="Home" class="btn btn-danger btn-lg mt-5">
            </form>
        </div>

    </body>
</html>

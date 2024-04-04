<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa; /* Màu nền */
            }
            .form-container {
                margin-top: 50px;
            }
            .btn-primary {
                background-color: #007bff; /* Màu nền của nút */
                border-color: #007bff; /* Màu viền của nút */
            }
            .btn-primary:hover {
                background-color: #0056b3; /* Màu nền khi di chuột qua */
                border-color: #0056b3; /* Màu viền khi di chuột qua */
            }
        </style>
    </head>
    <body>
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD' }">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
    <div class="container form-container">

        <h1 class="text-center">Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>

        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <form action="MainController">
                    <button type="submit" class="btn btn-success btn-block" name="action" value="UserManagement">User Management</button>
                </form>
            </div>
        </div>

        <div class="row justify-content-center mt-3">
            <div class="col-md-6">
                <form action="MainController">
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ProductManagement">Product Management</button>
                </form>
            </div>
        </div>

        <div class="row justify-content-center mt-3">
            <div class="col-md-6">
                <form action="MainController">
                    <button type="submit" class="btn btn-success btn-block" name="action" value="RevenueManagement">Revenue Management</button>
                </form>
            </div>
        </div>

        <div class="row justify-content-center mt-3">
            <div class="col-md-6">
                <form action="MainController">
                    <button type="submit" class="btn btn-danger btn-block" name="action" value="Logout">Logout</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

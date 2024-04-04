<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            .container {
                width: 80%; 
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <h1 class="text-center mt-4">Welcome: ${sessionScope.LOGIN_USER.fullName}</h1>
        <h4 class="text-center text-success mt-4">${requestScope.MESSAGE}</h4>
        <div class="container mt-4">
            <form action="MainController" class="mb-4">
                <div class="form-row align-items-center">
                    <div class="col-auto">
                        <label for="search" class="sr-only">Search</label>
                        <input type="text" name="search" id="search" class="form-control" placeholder="Search" value="${param.search}">
                    </div>
                    <div class="col-auto">
                        <input type="submit" name="action" value="Search" class="btn btn-primary">
                    </div>
                </div>
            </form>

            <c:if test="${not empty requestScope.LIST_USER}">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead class="thead-light">
                            <tr>
                                <th>No</th>
                                <th>User ID</th>
                                <th>Full Name</th>
                                <th>Password</th>
                                <th>RoleID</th>
                                <th>Address</th>
                                <th>DOB</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Status</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
                            <form action="MainController" method="POST">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>
                                        <input type="text" name="userID" value="${user.userID}" style="min-width: 200px;" readonly class="form-control-plaintext">
                                        <input type="hidden" name="search" value="${param.search}">
                                    </td>
                                    <td><input type="text" name="fullName" value="${user.fullName}" class="form-control" style="min-width: 200px;"></td>
                                    <td>${user.password}</td>
                                    <td><input type="text" name="roleID" value="${user.roleID}" class="form-control" style="min-width: 100px;"></td>
                                    <td><input type="text" name="address" value="${user.address}" class="form-control" style="min-width: 200px;"></td>
                                    <td><input type="date" name="dob" value="${user.dob}" class="form-control" style="min-width: 150px;"></td>
                                    <td><input type="text" name="phone" value="${user.phone}" class="form-control" style="min-width: 150px;"></td>
                                    <td><input type="text" name="email" value="${user.email}" class="form-control" style="min-width: 250px;"></td>
                                    <td><input type="number" name="status" value="${user.status}" class="form-control" style="min-width: 100px;"></td>
                                    <td><input type="submit" name="action" value="Update" class="btn btn-primary"></td>
                                    <td><input type="submit" name="action" value="Delete" class="btn btn-danger"></td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <h3 class="text-danger">${requestScope.ERROR}</h3>

            <form action="MainController" class="mb-4">
                <input type="submit" name="action" value="CreateUserPage" class="btn btn-primary">
            </form>
            <h5 class="text-success">${requestScope.MESSAGE}</h5>
        </div>

        <div class="container mt-4">
            <form action="MainController">
                <input type="submit" name="action" value="TopCustomer" class="btn btn-primary">
            </form>

            <c:if test="${not empty requestScope.LIST_TOP_CUSTOMER}">
                <div class="table-responsive">
                    <table class="table table-bordered mt-4">
                        <thead class="thead-light">
                            <tr>
                                <th>No</th>
                                <th>User ID</th>
                                <th>Full Name</th>
                                <th>Address</th>
                                <th>DOB</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Spent</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_TOP_CUSTOMER}">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${user.userID}</td>
                                    <td>${user.fullName}</td>
                                    <td>${user.address}</td>
                                    <td>${user.dob}</td>
                                    <td>${user.phone}</td>
                                    <td>${user.email}</td>
                                    <td><fmt:formatNumber pattern="#,###">${user.spent}</fmt:formatNumber> VND</td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>

        <div class="container mt-4">
            <form action="MainController">
                <input type="submit" name="action" value="Home" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>

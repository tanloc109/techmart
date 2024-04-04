<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <title>Revenue Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa; /* Màu nền */
        }
    </style>
</head>
<body>
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD' }">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Revenue Management</h1>

        <div class="row">
            <!-- Cột bên trái -->
            <div class="col-md-4">
                <!-- Form report by day -->
                <form action="MainController">
                    <div class="form-group">
                        <label>Report revenue by day:</label>
                        <input type="date" class="form-control" name="search" value="${param.search}">
                    </div>
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ReportRevenueByDay">Report</button>
                </form>
                <h1 class="mt-4"><fmt:formatNumber pattern="#,###">${requestScope.REVENUEBYDATE}</fmt:formatNumber></h1>

                <!-- Form report by month -->
                <form action="MainController" class="mt-4">
                    <div class="form-group">
                        <label>Report revenue by month:</label>
                        <input type="month" class="form-control" name="search" value="${param.search}">
                    </div>
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ReportRevenueByMonth">Report</button>
                </form>
                <h1 class="mt-4"><fmt:formatNumber pattern="#,###">${requestScope.REVENUEBYMONTH}</fmt:formatNumber></h1>
            </div>

            <!-- Cột giữa -->
            <div class="col-md-4">
                <!-- Form report by year -->
                <form action="MainController">
                    <div class="form-group">
                        <label>Report revenue by year:</label>
                        <input type="number" class="form-control" name="search" value="${param.search}" min="0">
                    </div>
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ReportRevenueByYear">Report</button>
                </form>
                <h1 class="mt-4"><fmt:formatNumber pattern="#,###">${requestScope.REVENUEBYYEAR}</fmt:formatNumber></h1>

                <!-- Form report in range -->
                <form action="MainController" class="mt-4">
                    <div class="form-group">
                        <label>Report revenue in range:</label>
                        <input type="date" class="form-control" name="dateStart" value="${param.dateStart}" placeholder="Date start">
                        <input type="date" class="form-control mt-2" name="dateEnd" value="${param.dateEnd}" placeholder="Date end">
                    </div>
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ReportRevenueInRange">Report</button>
                </form>
                <h1 class="mt-4"><fmt:formatNumber pattern="#,###">${requestScope.REVENUEINRANGE}</fmt:formatNumber></h1>
            </div>

            <!-- Cột bên phải -->
            <div class="col-md-4">
                <!-- Form report daily -->
                <form action="MainController">
                    <button type="submit" class="btn btn-success btn-block mt-4" name="action" value="ReportRevenueDaily">Report revenue daily</button>
                </form>
                <c:if test="${requestScope.LIST_REVENUE_DAILY != null}">
                    <table class="table table-striped mt-3">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Date</th>
                                <th scope="col">Revenue</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="a" varStatus="c" items="${requestScope.LIST_REVENUE_DAILY}">
                                <tr>
                                    <td>${c.count}</td>
                                    <td>${a.date}</td>
                                    <td><fmt:formatNumber pattern="#,###">${a.revenue}</fmt:formatNumber> VND</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <!-- Form report monthly -->
                <form action="MainController" class="mt-4">
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ReportRevenueMonthly">Report revenue monthly</button>
                </form>
                <c:if test="${requestScope.LIST_REVENUE_MONTHLY != null}">
                    <table class="table table-striped mt-3">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Month</th>
                                <th scope="col">Revenue</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="a" varStatus="c" items="${requestScope.LIST_REVENUE_MONTHLY}">
                                <tr>
                                    <td>${c.count}</td>
                                    <td>${a.date}</td>
                                    <td><fmt:formatNumber pattern="#,###">${a.revenue}</fmt:formatNumber> VND</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <!-- Form report yearly -->
                <form action="MainController" class="mt-4">
                    <button type="submit" class="btn btn-success btn-block" name="action" value="ReportRevenueYearly">Report revenue yearly</button>
                </form>
                <c:if test="${requestScope.LIST_REVENUE_YEARLY != null}">
                    <table class="table table-striped mt-3">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
                                <th scope="col">Year</th>
                                <th scope="col">Revenue</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="a" varStatus="c" items="${requestScope.LIST_REVENUE_YEARLY}">
                                <tr>
                                    <td>${c.count}</td>
                                    <td>${a.date}</td>
                                    <td><fmt:formatNumber pattern="#,###">${a.revenue}</fmt:formatNumber> VND</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>

        <!-- Nút Home ở giữa -->
        <div class="row mt-4">
            <div class="col-md-12">
                <form action="MainController">
                    <button type="submit" class="btn btn-primary btn-block" name="action" value="Home">Home</button>
                </form>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

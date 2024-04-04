<%-- 
    Document   : shopcart
    Created on : Mar 12, 2024, 4:49:07 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">

        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <title>Shopping Cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{margin-top:20px;}
            select.form-control:not([size]):not([multiple]) {
                height: 44px;
            }
            select.form-control {
                padding-right: 38px;
                background-position: center right 17px;
                background-image: url(data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNv…9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K);
                background-repeat: no-repeat;
                background-size: 9px 9px;
            }
            .form-control:not(textarea) {
                height: 44px;
            }
            .form-control {
                padding: 0 18px 3px;
                border: 1px solid #dbe2e8;
                border-radius: 22px;
                background-color: #fff;
                color: #606975;
                font-family: "Maven Pro",Helvetica,Arial,sans-serif;
                font-size: 14px;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
            }

            .shopping-cart,
            .wishlist-table,
            .order-table {
                margin-bottom: 20px
            }

            .shopping-cart .table,
            .wishlist-table .table,
            .order-table .table {
                margin-bottom: 0
            }

            .shopping-cart .btn,
            .wishlist-table .btn,
            .order-table .btn {
                margin: 0
            }

            .shopping-cart>table>thead>tr>th,
            .shopping-cart>table>thead>tr>td,
            .shopping-cart>table>tbody>tr>th,
            .shopping-cart>table>tbody>tr>td,
            .wishlist-table>table>thead>tr>th,
            .wishlist-table>table>thead>tr>td,
            .wishlist-table>table>tbody>tr>th,
            .wishlist-table>table>tbody>tr>td,
            .order-table>table>thead>tr>th,
            .order-table>table>thead>tr>td,
            .order-table>table>tbody>tr>th,
            .order-table>table>tbody>tr>td {
                vertical-align: middle !important
            }

            .shopping-cart>table thead th,
            .wishlist-table>table thead th,
            .order-table>table thead th {
                padding-top: 17px;
                padding-bottom: 17px;
                border-width: 1px
            }

            .shopping-cart .remove-from-cart,
            .wishlist-table .remove-from-cart,
            .order-table .remove-from-cart {
                display: inline-block;
                color: #ff5252;
                font-size: 18px;
                line-height: 1;
                text-decoration: none
            }

            .shopping-cart .count-input,
            .wishlist-table .count-input,
            .order-table .count-input {
                display: inline-block;
                width: 100%;
                width: 86px
            }

            .shopping-cart .product-item,
            .wishlist-table .product-item,
            .order-table .product-item {
                display: table;
                width: 100%;
                min-width: 150px;
                margin-top: 5px;
                margin-bottom: 3px
            }

            .shopping-cart .product-item .product-thumb,
            .shopping-cart .product-item .product-info,
            .wishlist-table .product-item .product-thumb,
            .wishlist-table .product-item .product-info,
            .order-table .product-item .product-thumb,
            .order-table .product-item .product-info {
                display: table-cell;
                vertical-align: top
            }

            .shopping-cart .product-item .product-thumb,
            .wishlist-table .product-item .product-thumb,
            .order-table .product-item .product-thumb {
                width: 130px;
                padding-right: 20px
            }

            .shopping-cart .product-item .product-thumb>img,
            .wishlist-table .product-item .product-thumb>img,
            .order-table .product-item .product-thumb>img {
                display: block;
                width: 100%
            }

            @media screen and (max-width: 860px) {
                .shopping-cart .product-item .product-thumb,
                .wishlist-table .product-item .product-thumb,
                .order-table .product-item .product-thumb {
                    display: none
                }
            }

            .shopping-cart .product-item .product-info span,
            .wishlist-table .product-item .product-info span,
            .order-table .product-item .product-info span {
                display: block;
                font-size: 13px
            }

            .shopping-cart .product-item .product-info span>em,
            .wishlist-table .product-item .product-info span>em,
            .order-table .product-item .product-info span>em {
                font-weight: 500;
                font-style: normal
            }

            .shopping-cart .product-item .product-title,
            .wishlist-table .product-item .product-title,
            .order-table .product-item .product-title {
                margin-bottom: 6px;
                padding-top: 5px;
                font-size: 16px;
                font-weight: 500
            }

            .shopping-cart .product-item .product-title>a,
            .wishlist-table .product-item .product-title>a,
            .order-table .product-item .product-title>a {
                transition: color .3s;
                color: #374250;
                line-height: 1.5;
                text-decoration: none
            }

            .shopping-cart .product-item .product-title>a:hover,
            .wishlist-table .product-item .product-title>a:hover,
            .order-table .product-item .product-title>a:hover {
                color: #0da9ef
            }

            .shopping-cart .product-item .product-title small,
            .wishlist-table .product-item .product-title small,
            .order-table .product-item .product-title small {
                display: inline;
                margin-left: 6px;
                font-weight: 500
            }

            .wishlist-table .product-item .product-thumb {
                display: table-cell !important
            }

            @media screen and (max-width: 576px) {
                .wishlist-table .product-item .product-thumb {
                    display: none !important
                }
            }

            .shopping-cart-footer {
                display: table;
                width: 100%;
                padding: 10px 0;
                border-top: 1px solid #e1e7ec
            }

            .shopping-cart-footer>.column {
                display: table-cell;
                padding: 5px 0;
                vertical-align: middle
            }

            .shopping-cart-footer>.column:last-child {
                text-align: right
            }

            .shopping-cart-footer>.column:last-child .btn {
                margin-right: 0;
                margin-left: 15px
            }

            @media (max-width: 768px) {
                .shopping-cart-footer>.column {
                    display: block;
                    width: 100%
                }
                .shopping-cart-footer>.column:last-child {
                    text-align: center
                }
                .shopping-cart-footer>.column .btn {
                    width: 100%;
                    margin: 12px 0 !important
                }
            }

            .coupon-form .form-control {
                display: inline-block;
                width: 100%;
                max-width: 235px;
                margin-right: 12px;
            }

            .form-control-sm:not(textarea) {
                height: 36px;
            }
            .product-item{
                display:flex;
            }

            .product-info {
                display:flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;}
            </style>

        </head>
        <body>
            <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US' }">
                <c:redirect url="login.jsp"></c:redirect>
            </c:if>
            <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
            <div class="container padding-bottom-3x mb-1">

            <div class="alert alert-info alert-dismissible fade show text-center" style="margin-bottom: 30px;"><span class="alert-close" data-dismiss="alert"></span><img class="d-inline align-center" src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iTGF5ZXJfMSIgeD0iMHB4IiB5PSIwcHgiIHZpZXdCb3g9IjAgMCA1MTIuMDAzIDUxMi4wMDMiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMi4wMDMgNTEyLjAwMzsiIHhtbDpzcGFjZT0icHJlc2VydmUiIHdpZHRoPSIxNnB4IiBoZWlnaHQ9IjE2cHgiPgo8Zz4KCTxnPgoJCTxnPgoJCQk8cGF0aCBkPSJNMjU2LjAwMSw2NGMtNzAuNTkyLDAtMTI4LDU3LjQwOC0xMjgsMTI4czU3LjQwOCwxMjgsMTI4LDEyOHMxMjgtNTcuNDA4LDEyOC0xMjhTMzI2LjU5Myw2NCwyNTYuMDAxLDY0eiAgICAgIE0yNTYuMDAxLDI5OC42NjdjLTU4LjgxNiwwLTEwNi42NjctNDcuODUxLTEwNi42NjctMTA2LjY2N1MxOTcuMTg1LDg1LjMzMywyNTYuMDAxLDg1LjMzM1MzNjIuNjY4LDEzMy4xODQsMzYyLjY2OCwxOTIgICAgIFMzMTQuODE3LDI5OC42NjcsMjU2LjAwMSwyOTguNjY3eiIgZmlsbD0iIzUwYzZlOSIvPgoJCQk8cGF0aCBkPSJNMzg1LjY0NCwzMzMuMjA1YzM4LjIyOS0zNS4xMzYsNjIuMzU3LTg1LjMzMyw2Mi4zNTctMTQxLjIwNWMwLTEwNS44NTYtODYuMTIzLTE5Mi0xOTItMTkycy0xOTIsODYuMTQ0LTE5MiwxOTIgICAgIGMwLDU1Ljg1MSwyNC4xMjgsMTA2LjA2OSw2Mi4zMzYsMTQxLjE4NEw2NC42ODQsNDk3LjZjLTEuNTM2LDQuMTE3LTAuNDA1LDguNzI1LDIuODM3LDExLjY2OSAgICAgYzIuMDI3LDEuNzkyLDQuNTY1LDIuNzMxLDcuMTQ3LDIuNzMxYzEuNjIxLDAsMy4yNDMtMC4zNjMsNC43NzktMS4xMDlsNzkuNzg3LTM5Ljg5M2w1OC44NTksMzkuMjMyICAgICBjMi42ODgsMS43OTIsNi4xMDEsMi4yNCw5LjE5NSwxLjI4YzMuMDkzLTEuMDAzLDUuNTY4LTMuMzQ5LDYuNjk5LTYuNGwyMy4yOTYtNjIuMTQ0bDIwLjU4Nyw2MS43MzkgICAgIGMxLjA2NywzLjE1NywzLjU0MSw1LjYzMiw2LjY3Nyw2LjcyYzMuMTM2LDEuMDY3LDYuNTkyLDAuNjQsOS4zNjUtMS4yMTZsNTguODU5LTM5LjIzMmw3OS43ODcsMzkuODkzICAgICBjMS41MzYsMC43NjgsMy4xNTcsMS4xMzEsNC43NzksMS4xMzFjMi41ODEsMCw1LjEyLTAuOTM5LDcuMTI1LTIuNzUyYzMuMjY0LTIuOTIzLDQuMzczLTcuNTUyLDIuODM3LTExLjY2OUwzODUuNjQ0LDMzMy4yMDV6ICAgICAgTTI0Ni4wMTcsNDEyLjI2N2wtMjcuMjg1LDcyLjc0N2wtNTIuODIxLTM1LjJjLTMuMi0yLjExMi03LjMxNy0yLjM4OS0xMC42ODgtMC42NjFMOTQuMTg4LDQ3OS42OGw0OS41NzktMTMyLjIyNCAgICAgYzI2Ljg1OSwxOS40MzUsNTguNzk1LDMyLjIxMyw5My41NDcsMzUuNjA1TDI0Ni43LDQxMS4yQzI0Ni40ODcsNDExLjU2MywyNDYuMTY3LDQxMS44NCwyNDYuMDE3LDQxMi4yNjd6IE0yNTYuMDAxLDM2Mi42NjcgICAgIEMxNjEuOSwzNjIuNjY3LDg1LjMzNSwyODYuMTAxLDg1LjMzNSwxOTJTMTYxLjksMjEuMzMzLDI1Ni4wMDEsMjEuMzMzUzQyNi42NjgsOTcuODk5LDQyNi42NjgsMTkyICAgICBTMzUwLjEwMywzNjIuNjY3LDI1Ni4wMDEsMzYyLjY2N3ogTTM1Ni43NTksNDQ5LjEzMWMtMy40MTMtMS43MjgtNy41MDktMS40NzItMTAuNjg4LDAuNjYxbC01Mi4zNzMsMzQuOTIzbC0zMy42NDMtMTAwLjkyOCAgICAgYzQwLjM0MS0wLjg1Myw3Ny41ODktMTQuMTg3LDEwOC4xNi0zNi4zMzFsNDkuNTc5LDEzMi4yMDNMMzU2Ljc1OSw0NDkuMTMxeiIgZmlsbD0iIzUwYzZlOSIvPgoJCTwvZz4KCTwvZz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K" width="18" height="18" alt="Medal icon">&nbsp;&nbsp;YOUR SHOPPING BAG HERE.</div>
                <c:if test="${sessionScope.CART != null}">
                    <c:if test="${not empty sessionScope.CART}">
                    <div class="table-responsive shopping-cart">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th class="text-center">No</th>
                                    <th class="text-center">Product Name</th>
                                    <th class="text-center">Price</th>
                                    <th class="text-center">Quantity</th>
                                    <th class="text-center">Subtotal</th>
                                    <th class="text-center">Update</th>
                                    <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="MainController?action=ClearCart">Clear Cart</a></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="total" value="0"/>
                                <c:forEach var="product" varStatus="counter" items="${sessionScope.CART.getCart().values()}">
                                    <c:set var="total" value="${total + (product.getPrice() * product.getQuantity())}"/>
                                <form action="MainController">
                                    <tr>
                                        <td class="text-center">
                                            ${counter.count}
                                            <input type="hidden" name="id" value="${product.getProductID()}"/>
                                        </td>
                                        <td class="text-center d-flex align-items-center">
                                            <div class="product-item">
                                                <!--                                                <a class="product-thumb" href="#">
                                                                                                    <img src="https://www.bootdey.com/image/220x180/FF0000/000000" alt="Product">
                                                                                                </a>-->
                                                <div class="product-info">
                                                    <h4 class="product-title">
                                                        <a href="#">${product.getProductName()}</a>
                                                    </h4>
                                                    <span><em>Memory:</em> ${product.getMemory()}GB</span>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="text-center">
                                            <fmt:formatNumber pattern="#,###">${product.getPrice()}</fmt:formatNumber>VND
                                            </td>
                                            <td class="text-center">
                                                <input type="number" name="quantity" min="1" value="${product.getQuantity()}" />
                                        </td>
                                        <td class="text-center">
                                            <fmt:formatNumber pattern="#,###">${product.getPrice() * product.getQuantity()}</fmt:formatNumber>VND
                                            </td>
                                            <td class="text-center">
                                                <div class="column">
                                                    <input class="btn btn-primary" type="submit" name="action" value="Edit"/>
                                                </div>
                                            </td>
                                            <td class="text-center text-danger">
                                                <i class="fa fa-trash "></i>
                                                <input class="btn btn-danger b" type="submit" name="action" value="Remove"/> 
                                            </td>
                                        </tr>
                                    </form>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="shopping-cart-footer">
                        <div class="column">
                            <form class="coupon-form" method="post">
                                <input class="form-control form-control-sm" type="text" placeholder="Coupon code" required>
                                <button class="btn btn-outline-primary btn-sm" type="submit">Apply Coupon</button>
                            </form>
                        </div>
                        <div class="column text-lg">Subtotal: <span class="text-medium"><fmt:formatNumber pattern="#,###">${total}</fmt:formatNumber>VND</span></div>
                        </div>
                        <div class="shopping-cart-footer">
                            <div class="column"><a class="btn btn-outline-secondary" href="MainController?action=Shopping"><i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a></div>
                            <div class="column">
                                <a class="btn btn-success" href="MainController?action=CheckOut">CheckOut</a>
                            </div>
                        </div>
                        <h5 class="text-center text-danger">${requestScope.PRODUCT_ERROR.getQuantityError()}</h5>
                </div>
            </c:if>
        </c:if>
        <c:if test="${sessionScope.CART == null || empty sessionScope.CART}">
            <h3 class="text-danger text-center">Your shooping bag <strong>DON'T HAVE</strong> any product.</h3>
            <div class="shopping-cart-footer">
                <div class="column"><a class="btn btn-outline-secondary" href="MainController?action=Shopping"><i class="icon-arrow-left"></i>&nbsp;Back to Shopping</a></div>
            </div>
        </c:if>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">
        </script>
    </body>
</html>
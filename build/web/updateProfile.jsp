<%-- 
    Document   : user
    Created on : Jan 24, 2024, 10:13:26 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.sp24.t4s2.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            .gradient-custom {
                /* fallback for old browsers */
                background: #f6d365;

                /* Chrome 10-25, Safari 5.1-6 */
                background: -webkit-linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));

                /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                background: linear-gradient(to right bottom, rgba(246, 211, 101, 1), rgba(253, 160, 133, 1));

            }
            .mar-32 {
                margin:12px;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US' } ">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>


        <section class="vh-100" style="background-color: #f4f5f7;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-lg-8 mb-4 mb-lg-0">
                        <div class="card mb-3" style="border-radius: .5rem;">
                            <div class="row g-0">
                                <div class="col-md-4 gradient-custom text-center text-white" style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava1-bg.webp" alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
                                    <h5>userID: ${sessionScope.LOGIN_USER.getUserID()}</h5>
                                </div>

                                <div class="col-md-8">
                                    <div class="card-body p-4">
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="userID" value="${sessionScope.LOGIN_USER.getUserID()}" readonly=""/>
                                            <input type="hidden" name="password" value="${user.password}" />
                                            <input type="hidden" name="roleID" value="${sessionScope.LOGIN_USER.getRoleID()}" />
                                            <h6>Information</h6>
                                            <hr class="mt-0 mb-4">
                                            <div class="row pt-1">
                                                <div class="col-6 mb-3">
                                                    <h6>Fullname</h6>
                                                    <input type="text" name="fullName" value="${sessionScope.LOGIN_USER.getFullName()}" required="" minlength="2" maxlength="20"/>
                                                </div>
                                                <div class="col-6 mb-3">
                                                    <h6>Phone</h6>
                                                    <input type="text" name="phone" value="${sessionScope.LOGIN_USER.getPhone()}" required=""/>
                                                </div>
                                            </div>
                                            <hr class="mt-0 mb-4">
                                            <div class="row pt-1">
                                                <div class="col-6 mb-3">
                                                    <h6>Address</h6>
                                                    <input type="text" name="address" value="${sessionScope.LOGIN_USER.getAddress()}" required=""/>
                                                </div>
                                                <div class="col-6 mb-3">
                                                    <h6>Date of birth</h6>
                                                    <input type="date" name="dob" value="${sessionScope.LOGIN_USER.getDob()}" required=""/>
                                                </div>
                                            </div>
                                            <hr class="mt-0 mb-4">
                                            <div class="row pt-1">
                                                <div class="col-6 mb-3">
                                                    <h6>Email</h6>
                                                    <input type="email" name="email" value="${sessionScope.LOGIN_USER.getEmail()}" required=""/>
                                                </div>
                                                <div class="col-6 mb-3">
                                                    <h6>Role</h6>
                                                    <p class="text-muted">${sessionScope.LOGIN_USER.getRoleID()}</p>
                                                </div>
                                            </div>
                                            <input class="btn btn-success" type="submit" name="action" value="UpdateMyProfile"/>
                                            <input class="btn btn-dark" type="reset" value="Reset"/>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>    
    </body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <title>Register</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD' }">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>
    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Register</h2>
                        <form method="POST" class="register-form" id="register-form" action="MainController">
                            <div class="form-group">
                                <label for="userID"><i class="material-icons">account_circle</i></label>
                                <input type="text" name="userID" placeholder="Your userID" required="" minlength="2" maxlength="10" value="${param.userID}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getUserIDError()}</h5>
                            <div class="form-group">
                                <label for="name"><i class="material-icons">account_circle</i></label>
                                <input type="text" name="fullName" placeholder="Your Name" value="${param.fullName}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getFullNameError()}</h5>
                            <div class="form-group">
                                <label for="pass"><i class="material-icons">lock</i></label>
                                <input type="password" name="password" placeholder="Password" required="" value="${param.password}"/>
                            </div>
                            <div class="form-group">
                                <label for="name"><i class="material-icons">lock_outline</i></label>
                                <input type="password" name="confirm" placeholder="Repeat your password" required="" value="${param.confirm}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getConfirmError()}</h5>
                            <div class="form-group">
                                <label for="name"><i class="material-icons">location_on</i></label>
                                <input type="text" name="address" placeholder="Your Address" value="${param.address}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getAddressError()}</h5>
                            <div class="form-group">
                                <label for="dob"><i class="material-icons">date_range</i></label>
                                <input type="date" name="dob" placeholder="Your dob" value="${param.dob}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getDobError()}</h5>
                            <div class="form-group">
                                <label for="phone"><i class="material-icons">phone</i></label>
                                <input type="text" name="phone" placeholder="Your Phone" value="${param.phone}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getPhoneError()}</h5>
                            <div class="form-group ">
                                <label for="email"><i class="material-icons">email</i></label>
                                <input type="email" name="email" placeholder="Your Email" value="${param.email}"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getEmailError()}</h5>
                            <div class="form-group form-button">
                                <input type="submit" name="action" class="form-submit" value="CreateFromLogin"/>
                            </div>
                            <div class="form-group form-button">
                                <input type="reset" class="form-submit" value="Reset"/>
                            </div>
                            <h5 class="text-danger text-center">${requestScope.USER_ERROR.getError()}</h5>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="MainController?action=BackLogin" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
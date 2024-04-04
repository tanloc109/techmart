<%-- 
    Document   : loginNew
    Created on : Mar 11, 2024, 9:35:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Apple Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img src="images/img-01.png" alt="IMG">
                    </div>

                    <div>
                        <form class="login100-form validate-form" action="MainController" method="POST" id="loginForm">
                            <span class="login100-form-title">
                                Tiem Nha Tao
                            </span>

                            <div class="wrap-input100 validate-input">
                                <input class="input100" type="text" name="userID" placeholder="userID" required="">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                            </div>

                            <div class="wrap-input100 validate-input" data-validate = "Password is required">
                                <input class="input100" type="password" name="password" placeholder="Password">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-lock" aria-hidden="true"></i>
                                </span>
                            </div>

                            <div class="container-login100-form-btn">
                                <input class="login100-form-btn" type="submit" name="action" value="Login" />
                            </div>

                        </form>
                        <div class="text-center text-danger">${requestScope.ERROR}</div>
                        <div class="text-center text-lg">
                            <span class="txt1">
                                Forgot
                            </span>
                            <a class="txt2" href="forgotPassword.jsp">
                                UserID / Password?
                            </a>
                        </div>

                        <form class="login100-form validate-form p-t-16" id="googleLoginForm" action="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/UserManagementT4S2_Apple_V2/LoginGoogleHandler&response_type=code&client_id=29332572771-38kg86ri97pp11a3vj9b8vqrlu3vat52.apps.googleusercontent.com&approval_prompt=force" method="POST">
                            <button class="login100-form-btn login-with-google" type="button" onclick="submitGoogleLoginForm()">
                                <i class="fa fa-google"></i> Login with Google
                            </button>
                        </form>
                        </br>
                        </br>

                        <div>
                            <h5 class="text-success text-center">${requestScope.MESSAGE}</h3>
                        </div>


                        <div class="text-center p-t-48" id="createForm">
                            <div class="g-recaptcha" data-sitekey="6LebSJQpAAAAAISMWULV7psh7tYgE0hvu1Igr931"></div>
                            <div id="error"></div>
                            <a class="txt2" href="#" id="createAccountLink">
                                Create your Account
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/tilt/tilt.jquery.min.js"></script>
        <script >
                                $('.js-tilt').tilt({
                                    scale: 1.1
                                })
        </script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script>
                                window.onload = function () {
                                    const createAccountLink = document.getElementById("createAccountLink");
                                    const error = document.getElementById("error");

                                    createAccountLink.addEventListener("click", function (event) {
                                        const response = grecaptcha.getResponse();
                                        if (!response) {
                                            event.preventDefault();
                                            error.innerHTML = "Please check the reCAPTCHA.";
                                        } else {
                                            // Nếu reCAPTCHA đã được kiểm chứng, chuyển hướng đến trang tạo tài khoản mới
                                            window.location.href = "MainController?action=Create_User_Page_From_Login";
                                        }
                                    });
                                };
                                function submitGoogleLoginForm() {
                                    document.getElementById("googleLoginForm").submit();
                                }
        </script>
    </body>
</html>

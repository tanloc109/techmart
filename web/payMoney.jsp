<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <title>Payment Successful</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            text-align: center;
        }
        h1 {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Congratulations! Your payment was successful.</h1>
        <form id="homeForm" action="MainController">
            <input type="submit" name="action" value="HomeUser" class="btn btn-primary">
        </form>
    </div>

    <script>
        // Hàm để chuyển hướng về trang chính sau 3 giây
        function redirectHome() {
            setTimeout(function(){
                document.getElementById('homeForm').submit();
            }, 3000);
        }
        
        // Gọi hàm redirectHome khi trang đã load
        window.onload = redirectHome;
    </script>
</body>
</html>

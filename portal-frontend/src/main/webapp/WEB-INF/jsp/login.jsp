<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<style>
    body {
        font-family: "Karla", sans-serif;
        background: url('https://uploads-ssl.webflow.com/5eaac2620e0334a0e78c42f4/5eab0fb6ff62007b9876d1f5_5e14ef152f2e01316cec3608_16282806_3_header_returnsprocessing-e1416260444841.png');
        min-height: 100vh;
    }

    .brand-wrapper {
        margin-bottom: 19px;
    }

    .brand-wrapper .logo {
        height: 37px;
    }

    .login-card {
        border: 0;
        border-radius: 27.5px;
        box-shadow: 0 10px 30px 0 rgba(172, 168, 168, 0.43);
        overflow: hidden;
        margin-bottom: 3%;
        background: -webkit-linear-gradient(left, #ff0000, #ffa07a);
    }

    .login-card-img {
        border-radius: 0;
        position: absolute;
        width: 100%;
        height: 100%;
        -o-object-fit: cover;
        object-fit: cover;
    }

    .login-card .card-body {
        padding: 85px 60px 60px;
    }

    @media (max-width: 422px) {
        .login-card .card-body {
            padding: 35px 24px;
        }
    }

    .login-card-description {
        font-size: 25px;
        color: #000;
        font-weight: normal;
        margin-bottom: 23px;
    }

    .login-card form {
        max-width: 326px;
    }

    .login-card .form-control {
        border: 1px solid #d5dae2;
        padding: 15px 25px;
        margin-bottom: 20px;
        min-height: 45px;
        font-size: 13px;
        line-height: 15;
        font-weight: normal;
    }

    .login-card .form-control::-webkit-input-placeholder {
        color: #919aa3;
    }

    .login-card .form-control::-moz-placeholder {
        color: #919aa3;
    }

    .login-card .form-control:-ms-input-placeholder {
        color: #919aa3;
    }

    .login-card .form-control::-ms-input-placeholder {
        color: #919aa3;
    }

    .login-card .form-control::placeholder {
        color: #919aa3;
    }

    .login-card .login-btn {
        padding: 13px 20px 12px;
        background-color: red;
        border-radius: 4px;
        font-size: 17px;
        font-weight: bold;
        line-height: 20px;
        color: #fff;
        margin-bottom: 24px;
    }

    .login-card .login-btn:hover {
        border: 1px solid #000;
        background-color: transparent;
        color: #000;
    }

    .login-card .forgot-password-link {
        font-size: 14px;
        color: #919aa3;
        margin-bottom: 12px;
    }

    .login-card-footer-text {
        font-size: 16px;
        color: #0d2366;
        margin-bottom: 60px;
    }

    @media (max-width: 767px) {
        .login-card-footer-text {
            margin-bottom: 24px;
        }
    }

    .login-card-footer-nav a {
        font-size: 14px;
        color: black;
    }

    /*# sourceMappingURL=login.css.map */

</style>
<body>
<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
        <div class="card login-card">
            <div class="row no-gutters">
                <div class="col-md-7">
                    <div class="card-body">
                        <div class="brand-wrapper">
                            <img src="https://www.foggypinebooks.com/uploads/6/2/3/9/62392781/published/returns.png?1530990084 alt=" alt="logo"
                                 class="logo" style="width: 25%; height: 25%;">
                            <h1><b> Return Order Management</b></h1>
                        </div>
                        <p class="login-card-description"><b>Sign into your account</b></p>
                        <form action="login" method='POST'>
                            <div class="form-group">
                                <label for="username" class="sr-only">Username</label>
                                <input type="text" name="username" id="username" class="form-control"
                                       placeholder="Enter username">
                            </div>
                            <div class="form-group mb-4">
                                <label for="password" class="sr-only">Password</label>
                                <input type="password" name="password" id="password" class="form-control"
                                       placeholder="Enter password">
                            </div>
                            <button type="submit" name="submit" value="submit"
                                    class="btn btn-block login-btn mb-4">Login
                            </button>
                        </form>
                        <nav class="login-card-footer-nav">
                            <a href="#!">Terms of use.</a>
                            <a href="#!">Privacy policy</a>
                        </nav>
                    </div>
                </div>
                <div class="col-md-5">
                    <img src="https://koronapos.com/wp-content/uploads/2020/08/806036_5-New-Blog-Images-5_081820-1.png"
                         style="width: 100%; height: 100%;">
                </div>
                
            </div>
        </div>

</main>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>

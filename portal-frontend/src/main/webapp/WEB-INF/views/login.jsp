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

<body>
<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
        <div class="card login-card">
            <div class="row no-gutters">
                <div class="col-md-5">
                    <img src="https://www.secondnaturebyhand.com/DSN/secondnaturebyhandcom/Content/Images/Return-policy.png"
                         style="width: 100%; height: 100%;">
                </div>
                <div class="col-md-7">
                    <div class="card-body">
                        <div class="brand-wrapper">
                            <img src="https://image.flaticon.com/icons/png/512/1440/1440524.png" alt="logo"
                                 class="logo">
                            <h1> Return Order Management</h1>
                        </div>
                        <p class="login-card-description">Sign into your account</p>
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
            </div>
        </div>

</main>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>

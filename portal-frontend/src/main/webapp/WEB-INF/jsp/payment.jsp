<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Card Details</title>
    <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
    <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<style>

    body{
        background-image: url('https://uploads-ssl.webflow.com/5eaac2620e0334a0e78c42f4/5eab0fb6ff62007b9876d1f5_5e14ef152f2e01316cec3608_16282806_3_header_returnsprocessing-e1416260444841.png');
    }
    span {
        color: red;
        font-size: 20px;
    }

    .register {
        background: -webkit-linear-gradient(left, #ff0000, #ffa07a);
        margin-top: 3%;
        margin-bottom: 3%;
        padding: 3%;
        border-radius: 25px;
    }

    .register-left {
        text-align: center;
        color: #fff;
        margin-top: 4%;
    }

    .register-left input {
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        width: 60%;
        background: #f8f9fa;
        font-weight: bold;
        color: #383d41;
        margin-top: 30%;
        margin-bottom: 3%;
        cursor: pointer;
    }

    .register-right {
        background: #f8f9fa;
        border-radius: 25px;
    }

    .register-left img {
        margin-top: 15%;
        margin-bottom: 5%;
        width: 25%;
        -webkit-animation: mover 2s infinite alternate;
        animation: mover 1s infinite alternate;
    }

    @-webkit-keyframes mover {
        0% {
            transform: translateY(0);
        }
        100% {
            transform: translateY(-20px);
        }
    }

    @keyframes mover {
        0% {
            transform: translateY(0);
        }
        100% {
            transform: translateY(-20px);
        }
    }

    .register-left p {
        font-weight: lighter;
        padding: 12%;
        margin-top: -9%;
    }

    .register .register-form {
        padding: 10%;
        margin-top: 10%;
    }

    .btnRegister {
        float: right;
        margin-top: 10%;
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        background: #0062cc;
        color: #fff;
        font-weight: 600;
        width: 50%;
        cursor: pointer;
    }

    .register .nav-tabs {
        margin-top: 3%;
        border: none;
        background: #0062cc;
        border-radius: 1.5rem;
        width: 28%;
        float: right;
    }

    .register .nav-tabs .nav-link {
        padding: 2%;
        height: 34px;
        font-weight: 600;
        color: #fff;
        border-top-right-radius: 1.5rem;
        border-bottom-right-radius: 1.5rem;
    }

    .register .nav-tabs .nav-link:hover {
        border: none;
    }

    .register .nav-tabs .nav-link.active {
        width: 100px;
        color: #0062cc;
        border: 2px solid #0062cc;
        border-top-left-radius: 1.5rem;
        border-bottom-left-radius: 1.5rem;
    }

    .register-heading {
        text-align: center;
        margin-top: 8%;
        margin-bottom: -15%;
        color: black;
    }

    label {
        font-weight: bold;
    }
</style>
<body>
<div class="container register">
    <div class="row">
       
        <div class="col-md-9 register-right">

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel"
                     aria-labelledby="home-tab">
                    <h3 class="register-heading"><b>Enter the card details</b></h3>
                    <form role="form" method="POST" action="/payment">
                        <div class="row register-form">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="creditCardNumber">Credit Card Number</label><span>
											*</span> <input type="text" class="form-control"
                                                            placeholder="Credit Card" type="tel" pattern="[0-9]+"
                                                            length="12" class="form-control" name="creditCardNumber"
                                                            id="creditCardNumber"
                                                            placeholder="Enter 16 digit Credit Card Number"
                                                            value="" required="required" maxlength="16" minlength="16"/>

                                </div>
                                <div class="form-group">
                                    <label for="name">Cardholder's Name</label><span>
											*</span>
                                    <input type="text" name="name" class="form-control" placeholder="Name on the card"
                                           required="required">
                                </div>

                                <div class="form-group">
                                    <label for="expDate">Expiration</label><span>
											*</span>
                                    <input type="text" name="exp" class="form-control" placeholder="MM/YY" size="5"
                                           id="exp" minlength="5" maxlength="5" required="required"/>
                                </div>

                                <div class="form-group">
                                    <label for="componentName">CVV</label><span>
											*</span>
                                    <input type="password" class="form-control" name="cvv"
                                           placeholder="&#9679;&#9679;&#9679;" size="1" minlength="3" maxlength="3"
                                           required="required">
                                </div>
                                <button type="submit" class="btn btn-danger">Confirm
                                    Payment
                                </button>

                            </div>
                            <div class="col-md-6">
                                <fieldset>


                                    <div class="form-group">
                                        <img src="https://img.icons8.com/color/48/000000/visa.png" width="64px"
                                             height="60px" style="margin-top: 25px; margin-left: 50px;"/>
                                    </div>


                                </fieldset>

                            </div>

                        </div>

                    </form>

                </div>

            </div>
            </div>
            <div class="col-md-3 register-left">
                <img src="https://www.foggypinebooks.com/uploads/6/2/3/9/62392781/published/returns.png?1530990084 alt=" 
                style="height: 15%; width: 35%;"/>
                <h1><b>Return Order Portal</b></h1>
                
            </div>
            
</body>
</html>

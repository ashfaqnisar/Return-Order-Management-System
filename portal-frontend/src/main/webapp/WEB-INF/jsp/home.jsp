<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link
            href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
            rel="stylesheet" id="bootstrap-css">
    <script
            src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        function checkHighPriority(that) {
            if (that.value == "integral") {

                document.getElementById("ifYes").style.display = "block";
            } else {
                document.getElementById("ifYes").style.display = "none";
            }
        }
    </script>
</head>
<style>
    body {
        background-image: url('https://uploads-ssl.webflow.com/5eaac2620e0334a0e78c42f4/5eab0fb6ff62007b9876d1f5_5e14ef152f2e01316cec3608_16282806_3_header_returnsprocessing-e1416260444841.png');
    }

    .text-secondary {
        text-align: right;
    }

    span {
        color: red;
        font-size: 20px;
    }

    .register {
        background: -webkit-linear-gradient(left, #ff0000, #ffa07a);
        margin-top: 3%;
        padding: 3%;
        border-radius: 25px;
        margin-bottom: 3%;
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
        border-radius: 25px;
        background: #f8f9fa;
        /*border-top-left-radius: 10% 50%;*/
        /*border-bottom-left-radius: 10% 50%;*/
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
        background: red;
        color: #fff;
        font-weight: 600;
        width: 50%;
        cursor: pointer;
    }

    .register .nav-tabs {
        margin-top: 3%;
        border: none;
        background: red;
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
        color: red;
        border: 2px solid red;
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
                    <h1 class="register-heading"><b>Return Order Details</b></h1>
                    <form role="form" method="POST" action="addprocessRequest">
                        <div class="row register-form">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="username">First Name</label><span> *</span>
                                    <input
                                            type="text" class="form-control"
                                            placeholder="Enter your First Name" value="" name="username"
                                            id="username" required="required"/>
                                </div>
                                <div class="form-group">
                                    <label for="username">Last Name</label> <input
                                        type="text" class="form-control"
                                        placeholder="Enter your Last Name" value=""
                                />
                                </div>
                                <div class="form-group">
                                    <label for="contactNumber">Contact Number </label><span>
											*</span> <input type="tel" class="form-control"
                                                            placeholder="Enter your Contact Number" value=""
                                                            name="contactNumber" id="contactNumber"
                                                            required="required"/>
                                </div>
                                <div class="form-group">
                                    <label for="home">Home Telephone Number </label>
                                    <input type="tel" class="form-control"
                                           placeholder="Home Telephone Number" value=""
                                           name="homeNumber" id="homeNumber"/>
                                </div>

                            </div>
                            <div class="col-md-6">
                                <fieldset>


                                    <div class="form-group">
                                        <label for="componentType">Select Component Type</label><span>
												*</span> <select class="form-control" name="componentType"
                                                                 id="componentType" required="required"
                                                                 onchange="checkHighPriority(this);">
                                        <option id="accessory" value="accessory">Accessory
                                            Component
                                        </option>
                                        <option id="integral" value="integral">Integral
                                            Component
                                        </option>
                                    </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="componentName">Component Name</label><span>
												*</span> <input type="text" class="form-control"
                                                                name="componentName" id="componentName"
                                                                placeholder="Enter the Component Name"
                                                                required="required">
                                    </div>
                                    <div class="form-group">
                                        <label for="quantityOfDefective">Quantity</label><span>
												*</span> <input type="text" class="form-control"
                                                                name="quantityOfDefective" id="quantityOfDefective"
                                                                placeholder="Enter the Component's Quantity"
                                                                required="required">
                                    </div>
                                    <div class="form-group">
                                        <div id="ifYes" style="display: none;">
                                            <label for="isPriorityRequest"> </label> <input type="checkbox" value="true"
                                                                                            id="isPriorityRequest"
                                                                                            name="isPriorityRequest">
                                            <b>Order is of High
                                                Priority.</b>

                                        </div>
                                    </div>
                                </fieldset>
                                <button type="submit" class="btn btn-danger">Confirm
                                    Return
                                </button>

                            </div>

                        </div>
                        <p class="text-secondary">Note: The order will be considered as return for integral components
                            and as replacement for accessories.</p>
                    </form>

                </div>

            </div>
        </div>
        <div class="col-md-3 register-left">
            <img src="https://www.foggypinebooks.com/uploads/6/2/3/9/62392781/published/returns.png?1530990084 alt="
                 style="height: 35%; width: 75%;"/>
            <h1><b>Welcome!</b></h1>
            <p><b>You are few seconds away from returning your product!</b></p>
        </div>
    </div>
</body>
</html>

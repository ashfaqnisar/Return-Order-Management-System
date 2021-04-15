<%--
  Created by IntelliJ IDEA.
  User: Ashfaq Nisar
  Date: 15-04-2021
  Time: 23:21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJs" />
    <spring:url value="/resources/fonts/inter.css" var="interCSS" />
    <spring:url value="/resources/styles/bootstrap.min.css" var="bootstrapCSS" />
    <spring:url value="/resources/styles/main.css" var="mainCSS" />

    <title>Login</title>
    <link href="${bootstrapCSS}" rel="stylesheet" />
    <link href="${interCSS}" rel="stylesheet" />
    <link href="${mainCSS}" rel="stylesheet" />
    <script src="${bootstrapJs}"></script>
</head>
<body>
<div>
    <h1>Login</h1>
    <form:form action="/login" method='POST' modelAttribute="loginUserRequest">
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
                class="btn btn-primary">Login
        </button>
    </form:form>
</div>
</body>
</html>

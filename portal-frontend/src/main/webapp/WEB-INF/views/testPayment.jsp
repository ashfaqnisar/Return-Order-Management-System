<%--
  Created by IntelliJ IDEA.
  User: Ashfaq Nisar
  Date: 16-04-2021
  Time: 00:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><html>
<head>
    <spring:url value="/resources/js/bootstrap.bundle.min.js" var="bootstrapJs" />
    <spring:url value="/resources/fonts/inter.css" var="interCSS" />
    <spring:url value="/resources/styles/bootstrap.min.css" var="bootstrapCSS" />
    <spring:url value="/resources/styles/main.css" var="mainCSS" />

    <title>Payment</title>
    <link href="${bootstrapCSS}" rel="stylesheet" />
    <link href="${interCSS}" rel="stylesheet" />
    <link href="${mainCSS}" rel="stylesheet" />
    <script src="${bootstrapJs}"></script>
</head>
<body>
<div>
    <h1>Payment</h1>
</div>
</body>
</html>

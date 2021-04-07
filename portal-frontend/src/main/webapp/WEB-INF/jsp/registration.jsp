<%--
  Created by IntelliJ IDEA.
  User: Ashfaq Nisar
  Date: 09-03-2021
  Time: 07:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
<main>
    <h1>Registration</h1>
    <form:form modelAttribute="registrationModel">
        <table>
            <tr>
                <td>
                    <spring:message code="name"/>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add Registration">
                </td>
            </tr>
        </table>
    </form:form>
</main>
</body>
</html>

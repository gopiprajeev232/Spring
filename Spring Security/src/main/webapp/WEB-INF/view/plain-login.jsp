<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Login form</title>
    </head>
    <body>
        <h3>Custom Login Page</h3>
        <hr>
        <form:form action = "${pageContext.request.contextPath}/authenticateUser" method="POST">
            <c:if test="${param.error != null}">
                <i>Invalid username/password.</i>
            </c:if>
            <p>
                Username: <input type="text" name="username" />
            </p>
            <p>
                Password: <input type="password" name="password" />
            </p>
            <input type="submit" value="Login" />
        </form:form>
    <body>
<html>
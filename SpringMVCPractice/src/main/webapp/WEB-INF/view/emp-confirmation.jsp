<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Employee Confirmation Form</title>
    </head>
    <body>
        The employee is confirmed.
        <br>
        Name: ${employee.firstName} ${employee.lastName} <br>
        Country: ${employee.country} <br>
        Position: ${employee.empPosition} <br>
        <br>
        Familiar languages: <br>
        <c:forEach var="temp" items="${employee.familiarLanguages}">
            <li>${temp}</li>
        </c:forEach>
    </body>
</html>
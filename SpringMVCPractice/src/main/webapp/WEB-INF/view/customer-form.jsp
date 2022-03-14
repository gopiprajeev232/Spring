<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Customer Registration</title>
    </head>
    <style>
        .error { color:red; }
    </style>
    <body>
        <form:form action="processForm" modelAttribute="customer">
            Name: <form:input path="name" />
            <form:errors path="name" cssClass="error" />
            <br><br>

            Age: <form:input path="age" />
            <form:errors path="age" cssClass="error" />
            <br><br>

            Zip Code: <form:input path="zipCode" />
            <form:errors path="zipCode" cssClass="error" />
            <br><br>

            Bike Code: <form:input path="bikeCode" />
            <form:errors path="bikeCode" cssClass="error" />
            <br><br>

            <input type="submit" value="Submit" />

        </form:form>
    </body>
</html>
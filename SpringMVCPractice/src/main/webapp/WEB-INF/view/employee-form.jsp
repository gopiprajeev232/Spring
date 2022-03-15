<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Employee Registration Form</title>
    </head>
    <body>
        <form:form action="processForm" modelAttribute="employee">
            First name: <form:input path="firstName" placeholder = "Enter first name" />
            <br><br>

            Last name: <form:input path = "lastName" placeholder = "Enter last name" />
            <br><br>

            Country:
            <form:select path="country">
                <form:options items="${employee.countryOptions}" />
            </form:select>
            <br><br>

            Position:
            <form:radiobutton path="empPosition" value="Director" /> Director
            <form:radiobutton path="empPosition" value="Manager" /> Manager
            <form:radiobutton path="empPosition" value="Employee" /> Employee
            <form:radiobutton path="empPosition" value="Intern" /> Intern
            <br><br>

            Languages familiar with:
            <form:checkbox path="familiarLanguages" value="English" /> English
            <form:checkbox path="familiarLanguages" value="Hindi" /> Hindi
            <form:checkbox path="familiarLanguages" value="Telugu" /> Telugu
            <form:checkbox path="familiarLanguages" value="French" /> French

            <input type="submit" value="submit" />
        </form:form>
    </body>
</html>
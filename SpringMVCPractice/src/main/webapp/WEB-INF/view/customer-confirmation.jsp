<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Customer Confirmation Form</title>
    </head>
    <body>
        The employee is confirmed.
        <br>
        Name: ${customer.name} <br>
        Age: ${customer.age} <br>
        Zip Code: ${customer.zipCode} <br>
        Bike code: ${customer.bikeCode}
    </body>
</html>
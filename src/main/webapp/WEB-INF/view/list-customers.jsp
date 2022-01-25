<!-- add support for JSTL Core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Curtomer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <!-- html table here -->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <!-- loop over and print customers -->
            <c:forEach var="tempCustomer" items="${customers}">

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                </tr>

            </c:forEach>
        </table>

    </div>
</div>

</body>

</html>
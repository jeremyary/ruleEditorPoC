<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<html>
    <head>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    </head>
    <body>
        <h2>Exposed to Vehicle rules:</h2>
        <table>
            <thead>
                <th>name</th>
                <th>type</th>
                <th>readMethod</th>
                <th>ownerType</th>
            </thead>
            <tbody>
                <c:forEach items="${vehicleRuleElements}" var="element">
                    <tr>
                        <td>${element.name}</td>
                        <td>${element.type.simpleName}</td>
                        <td>${element.readMethod.name}</td>
                        <td>${element.ownerType.simpleName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h2>Exposed to Occupant rules:</h2>
        <table>
            <thead>
                <th>name</th>
                <th>type</th>
                <th>readMethod</th>
                <th>ownerType</th>
            </thead>
            <tbody>
                <c:forEach items="${occupantRuleElements}" var="element">
                    <tr>
                        <td>${element.name}</td>
                        <td>${element.type.simpleName}</td>
                        <td>${element.readMethod.name}</td>
                        <td>${element.ownerType.simpleName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
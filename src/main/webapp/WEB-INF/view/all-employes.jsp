<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllEmployes</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>

    </tr>
    <c:forEach var="emp" items="${allEmps}">    <!-- атрибут который указали в контроллере таким образом emp будит принимать значение каждого работника из этого списка!-->
        <c:url var="updateButton" value="/updateInfo"><!-- ссылка указывающая id работника используем ее в кнопке!-->
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmploye">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <tr>
    <td>${emp.name}</td>
    <td>${emp.surname}</td>
    <td>${emp.department}</td>
    <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href='${updateButton}'">

                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">
            </td>
</tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add" onclick="window.location.href='addNewEmployee'"/>
</body>
</html>

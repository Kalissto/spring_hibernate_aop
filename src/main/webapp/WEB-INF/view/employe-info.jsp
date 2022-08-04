<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employe Info</title>
</head>
<body>
<form:form action="saveEmploye" modelAttribute="employe">
    <form:hidden path="id"/><!--скрытая форма ,не видим но тоже будет заполнено как и name и т п-->
    Name <form:input path="name"/>;
    Surname <form:input path="surname"/>;
    Department <form:input path="department"/>;
    Salary <form:input path="salary"/>;

<input type="submit" value="OK">
</form:form>

</body>
</html>

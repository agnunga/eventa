<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h1>Customer Form</h1>
<%--<form action="#" th:action="@{/form}" th:object="${user}" method="post">--%>
    <%--<p>First Name: <input type="text" th:field="*{firstName}" /></p>--%>
    <%--<p>Last Name: <input type="text" th:field="*{lastName}" /></p>--%>
    <%--<p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>--%>
<%--</form>--%>

<h1>Customer Form</h1>
<s:form action="form" commandName="user" method="post">
    <p>First Name: <input type="text" path="firstName" /></p>
    <p>Last Name: <input type="text" path="lastName" /></p>
    <p>
        <input type="submit" value="Submit" />
        <input type="reset" value="Reset" />
    </p>
</s:form>
</body>
</html>
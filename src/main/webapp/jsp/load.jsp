<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Customer Info</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
oloo dsfdsd
<p th:text="'id: ' + ${user.id}" />
<p th:text="'First Name: ' + ${user.firstName}" />
<p th:text="'Last Name: ' + ${user.lastName}" />
</body>
</html>
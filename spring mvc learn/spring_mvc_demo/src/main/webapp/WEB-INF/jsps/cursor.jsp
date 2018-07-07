<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程目录</title>
</head>
<body>
    <h2>当前课程</h2>
    <table border="1">
        <tr>
            <td>${cursor.curId}</td>
            <td>${cursor.curName}</td>
            <td>${cursor.time}</td>
        </tr>
    </table>
</body>
</html>

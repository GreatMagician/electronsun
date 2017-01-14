<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/footer-style.css"/>>
</head>
<div class="footer">
    <div class="container1">
        <a href="/electronsun/index"><spring:message code="app.footer"/></a>
    </div>
    <div class="container2">
        <a href="feedback"><spring:message code="app.feedback"/></a>
    </div>
</div>
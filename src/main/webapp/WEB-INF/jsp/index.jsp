<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<head>
    <link rel="stylesheet" href="resources/css/index-style.css">
</head>
<body>
    <jsp:include page="fragments/header.jsp"/>
    <div class="content">
        <%--новости--%>
        <div class="news">
            <h2> <spring:message code="app.news"/> </h2>
        </div>
        <%--последнее шоу--%>
        <div class="shows">
           <h2> <spring:message code="app.shows"/></h2>
        </div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--Настройки безопастности заголовков для AJAX запросов--%>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title><spring:message code="app.title"/></title>
    <script type="text/javascript" src="/electronsun/webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script type="text/javascript" src=<c:url value="/resources/js/header.js"/>></script>
    <link rel="stylesheet" href=<c:url value="/resources/css/style.css"/>>
    <link rel="stylesheet" href=<c:url value="/resources/css/header-style.css"/>>
</head>

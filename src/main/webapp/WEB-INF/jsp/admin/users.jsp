<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="../fragments/header.jsp"/>

<head>
    <link rel="stylesheet" href=<c:url value="/webjars/datatables/1.10.12/css/jquery.dataTables.min.css"/>>
    <script type="text/javascript" src="/electronsun/webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/electronsun/webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/date.format.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/userDatatables.js"></script>

</head>
<h1><fmt:message key="users.title"/></h1>
<table class="display"  cellspacing="0" width="100%" id="datatableusers">
    <thead>
    <tr>
        <th><spring:message code="users.nick"/></th>
        <th><spring:message code="users.email"/></th>
        <th><spring:message code="users.roles"/></th>
        <th><spring:message code="users.registered"/></th>
        <th><spring:message code="users.firstName"/></th>
        <th><spring:message code="users.lastName"/></th>
        <th><spring:message code="users.active"/></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th><spring:message code="users.nick"/></th>
        <th><spring:message code="users.email"/></th>
        <th><spring:message code="users.roles"/></th>
        <th><spring:message code="users.registered"/></th>
        <th><spring:message code="users.firstName"/></th>
        <th><spring:message code="users.lastName"/></th>
        <th><spring:message code="users.active"/></th>
    </tr>
    </tfoot>
</table>


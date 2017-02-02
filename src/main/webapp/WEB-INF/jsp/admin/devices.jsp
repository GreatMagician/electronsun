<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../fragments/header.jsp"/>

<head>
    <link rel="stylesheet" href=<c:url value="/webjars/datatables/1.10.12/css/jquery.dataTables.min.css"/>>
    <link rel="stylesheet" href="/electronsun/resources/css/admin/admin.css">
    <script type="text/javascript" src="/electronsun/webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/electronsun/webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/admin/deviceDatatables.js"></script>
</head>
<body>
<h1><spring:message code="admin.device"/></h1>

<table class="display"  cellspacing="0" width="100%" id="datatabledevices">
    <thead>
    <tr>
        <th><spring:message code="device.product"/></th>
        <th><spring:message code="device.maxLed"/></th>
        <th><spring:message code="device.enabled"/></th>
        <th><spring:message code="device.user"/></th>
        <th><spring:message code="device.uuid"/></th>
        <th></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th><spring:message code="device.product"/></th>
        <th><spring:message code="device.maxLed"/></th>
        <th><spring:message code="device.enabled"/></th>
        <th><spring:message code="device.user"/></th>
        <th><spring:message code="device.uuid"/></th>
        <th></th>
    </tr>
    </tfoot>
</table>
<br/>
<table class="addTable" >
    <caption><h3><spring:message code="device.caption"/></h3></caption>
    <tr>
        <th><spring:message code="device.product"/></th>
        <th><spring:message code="device.user"/></th>
        <th></th>
    </tr>
    <tr>
        <td>
            <p><select id="add-select" onclick="addselect()" >
                <option disabled><spring:message code="product.select"/></option>
            </select></p>
        </td>
        <td><input type="text" id="user"></td>
        <td><input type="submit" id="btnAdd" onclick="addDevice()" value="<spring:message code="common.add"/>"></td>
    </tr>
</table>

</body>

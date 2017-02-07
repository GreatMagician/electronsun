<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="/electronsun/resources/js/lightshow/deviceShowModal.js" type="text/javascript" charset="utf-8" ></script>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/fragments/modalmenu/deviceShowModal.css"/>>

</head>


<h2> Мои приборы </h2>
<table class="display"  cellspacing="0"  id="datatabledevices">
    <thead>
    <tr>
        <th><spring:message code="device.name"/></th>
        <th><spring:message code="device.description"/></th>
        <th><spring:message code="device.register"/></th>
        <th><spring:message code="common.delete"/></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th><spring:message code="device.name"/></th>
        <th><spring:message code="device.description"/></th>
        <th><spring:message code="device.register"/></th>
        <th><spring:message code="common.delete"/></th>
    </tr>
    </tfoot>
</table>
<br/>
<table class="addTable" >
    <caption><h3><spring:message code="device.caption"/></h3></caption>
    <tr>
        <th><spring:message code="product.select"/></th>
        <th></th>
    </tr>
    <tr>
        <td>
            <p><select id="add-select" onclick="getAllProductToLed(optionId='option-device-', selectId='add-select')" >
                <option disabled><spring:message code="product.select"/></option>
            </select></p>
        </td>
        <td><input type="submit" class="modal-btn" id="btnAdd" onclick="addDevice()" value="<spring:message code="common.add"/>"></td>
    </tr>
</table>

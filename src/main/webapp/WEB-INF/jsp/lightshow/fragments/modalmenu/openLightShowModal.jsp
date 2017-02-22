<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="/electronsun/resources/js/lightshow/openLightShowModal.js" type="text/javascript" charset="utf-8" ></script>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/fragments/modalmenu/openLightShowModal.css"/>>

</head>


<h2> Мои световые шоу </h2>
<table class="display"  cellspacing="0"  id="datatablelightshow">
    <thead>
    <tr>
        <th><spring:message code="lightShow.name"/></th>
        <th><spring:message code="menu.device"/></th>
        <th><spring:message code="lightShow.remix"/></th>
        <th><spring:message code="lightShow.remixes"/></th>
        <th><spring:message code="lightShow.audio"/></th>
        <th><spring:message code="lightShow.public"/></th>
        <th><spring:message code="common.delete"/></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th><spring:message code="lightShow.name"/></th>
        <th><spring:message code="menu.device"/></th>
        <th><spring:message code="lightShow.remix"/></th>
        <th><spring:message code="lightShow.remixes"/></th>
        <th><spring:message code="lightShow.audio"/></th>
        <th><spring:message code="lightShow.public"/></th>
        <th><spring:message code="common.delete"/></th>
    </tr>
    </tfoot>
</table>
<br/>
<p> Чтобы открыть световое шоу, дважды кликните на его имени</p>
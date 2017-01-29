<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../fragments/header.jsp"/>

<head>
    <link rel="stylesheet" href=<c:url value="/webjars/datatables/1.10.12/css/jquery.dataTables.min.css"/>>
    <link rel="stylesheet" href="/electronsun/resources/css/admin/admin.css">
    <script type="text/javascript" src="/electronsun/webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/electronsun/webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/admin/productDatatables.js"></script>
</head>
<body>
<h1><spring:message code="product.title"/></h1>

<table class="display"  cellspacing="0" width="100%" id="datatableproducts">
    <thead>
    <tr>
        <th><spring:message code="product.name"/></th>
        <th><spring:message code="product.description"/></th>
        <th><spring:message code="product.price"/></th>
        <th><spring:message code="product.discount"/></th>
        <th><spring:message code="product.discountPrice"/></th>
        <th><spring:message code="product.maxLed"/></th>
        <th></th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th><spring:message code="product.name"/></th>
        <th><spring:message code="product.description"/></th>
        <th><spring:message code="product.price"/></th>
        <th><spring:message code="product.discount"/></th>
        <th><spring:message code="product.discountPrice"/></th>
        <th><spring:message code="product.maxLed"/></th>
        <th></th>
    </tr>
    </tfoot>
</table>
<br/>
<table class="addTable"  width="100%" >
    <caption><h3><spring:message code="product.caption"/></h3></caption>
    <tr>
        <th><spring:message code="product.name"/></th>
        <th><spring:message code="product.description"/></th>
        <th><spring:message code="product.price"/></th>
        <th><spring:message code="product.discount"/></th>
        <th><spring:message code="product.maxLed"/></th>
        <th></th>
    </tr>
    <tr>
        <td><input type="text" id="name"></td>
        <td><input type="text" id="description"></td>
        <td><input type="text" id="price"></td>
        <td><input type="text" id="discount"></td>
        <td><input type="text" value="0" id="maxLed"></td>
        <td><input type="submit" id="btnAdd" onclick="addProductClick()" value="<spring:message code="common.add"/>"></td>
    </tr>
</table>
</body>

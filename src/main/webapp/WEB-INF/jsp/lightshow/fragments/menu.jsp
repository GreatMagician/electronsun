<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>
    <script src="/electronsun/webjars/jquery-modal/0.8.0/jquery.modal.min.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="/electronsun/webjars/jquery-modal/0.8.0/jquery.modal.min.css" type="text/css" media="screen" />
    <link rel="stylesheet" href=<c:url value="/webjars/datatables/1.10.12/css/jquery.dataTables.min.css"/>>
    <script type="text/javascript" src="/electronsun/webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="/electronsun/webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/fragments/menu.css"/>>
    <script src="/electronsun/resources/js/lightshow/menu.js" type="text/javascript" charset="utf-8" ></script>
    <script src="/electronsun/resources/js/product.js" type="text/javascript" charset="utf-8" ></script>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/contextMenu.css"/>>
    <script src="/electronsun/resources/js/lightshow/contextMenu.js" type="text/javascript" charset="utf-8" ></script>

</head>


<ul class="show-menu">
    <li><a href="/electronsun/index"><fmt:message key="menu.main"/></a></li>
    <li class="menu-element"><a href="#createLightShowModal" rel="modal:open"><fmt:message key="menu.create"/></a></li>
    <li class="menu-element"><a href="#openLightShowModal" rel="modal:open"><fmt:message key="lightShow.show"/></a></li>
    <li class="menu-element"><a href="#remixLightShowModal" rel="modal:open"><fmt:message key="menu.remix"/></a></li>
    <li class="menu-element"><a href="#deviceLightShowModal" rel="modal:open"><fmt:message key="lightShow.device"/></a></li>
    <li class="menu-element"><a href="#orderLightShowModal" rel="modal:open"><fmt:message key="lightShow.order"/></a></li>
    <li class="menu-element"><a href="#helpLightShowModal" rel="modal:open"><fmt:message key="menu.help"/></a></li>

    <li class="show-user">
        <form:form  action="/electronsun/logout" method="post">
            <a class="prof" href="/electronsun/users/profile">${user.getName()}</a>
            <button type="submit"> <fmt:message key="app.logout"/></button>
        </form:form>
    </li>
</ul>

<%----------------------- Создание светового шоу----------------------------------------------------%>

<div  id="createLightShowModal" style="display:none;">
    <jsp:include page="./modalmenu/createShowModal.jsp"/>
</div>

<%----------------------- Мои шоу --------------------------------------------------------%>

<div id="openLightShowModal" style="display:none;">
    <jsp:include page="./modalmenu/openLightShowModal.jsp"/>
</div>

<%--------------------- Ремикс -----------------------------------------------------------------------------%>

<div id="remixLightShowModal" style="display:none;">
    <p>
        remixLightShow
    </p>
</div>

<%----------------------- Мои приборы -------------------------------------------------------------------------%>

<div id="deviceLightShowModal" style="display:none;">
    <jsp:include page="./modalmenu/deviceShowModal.jsp"/>
</div>

<%-------------------------- Мои заказы -----------------------------------------------------------------------%>

<div id="orderLightShowModal" style="display:none;">
    <p>
        orderLightShowModal
    </p>
</div>

<%-------------------------- Помощь -----------------------------------------------------------------------%>

<div id="helpLightShowModal" style="display:none;">
    <p>
        Помощь уже создаётся)
    </p>
</div>

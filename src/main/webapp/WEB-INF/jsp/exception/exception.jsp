<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>

<head>
    <script type="text/javascript" src="/electronsun/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/exception.js"></script>
</head>
<jsp:include page="../fragments/headTag.jsp"/>

<body>
    <jsp:include page="../fragments/header.jsp"/>

    <div class="modal">
        <br>
        <h4>Ошибка в приложении: </h4>
        <h2 id="message-error">${exception.message}</h2>
        <h3><a href="javascript:history.back();">Вернуться назад</a></h3> <br/>
        <!--
        <c:forEach items="${exception.stackTrace}" var="stackTrace">
            ${stackTrace}
        </c:forEach>
        -->
    </div>
    <jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
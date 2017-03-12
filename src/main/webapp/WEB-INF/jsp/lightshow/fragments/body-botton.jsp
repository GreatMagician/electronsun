<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/fragments/conteiner2.css"/>>
    <link rel="stylesheet" href=<c:url value="/webjars/jquery-ui/1.12.1/jquery-ui.min.css"/>>
    <script type="text/javascript" src="/electronsun/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
    <script src="/electronsun/resources/js/lightshow/body-botton.js" type="text/javascript" charset="utf-8" ></script>

</head>
<div class="show-container2">
    <div class="show-length">
        <div class="show-length-btn">
            <button id="length-btn-min">
                <img src=<c:url value="/resources/img/play/backward.png"/> alt="Меньше">
            </button>
            <button id="length-btn-max">
                <img src=<c:url value="/resources/img/play/forward.png"/> alt="Больше">
            </button>
        </div>
    </div>
    <div class="show-content">
        <div id="show-track-1">
            <label class="show-track-number" title="Номер дорожки">1</label>
        </div>
    </div>
    <div class="show-audio">

    </div>

</div>


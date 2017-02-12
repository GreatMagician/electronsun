<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/lightshow/fragments/modalmenu/createLightShowModal.css"/>>

</head>
<h2>Создание светового шоу</h2>
<table>
    <tr>
        <td><label>Введите название светового шоу:</label></td>
        <td><input type="text" name="name" id="nameCreateShow" value=""/> </td>
    </tr>
    <tr>
        <td><label>Выберите или <a href="#" onclick="opendeviceLightShow()">создайте</a> прибор:</label></td>
        <td>
            <select class="modal-select" id="create-select" name="deviceId"
                    onclick="loadUserDevices(optionId='option-show-', selectId='create-select')" >">
                <OPTION selected label="none" value="0"></OPTION>
            </select>
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input class="modal-btn" type="submit" id="create-btn" onclick="createShow()"
                   value="<fmt:message key="menu.create"/>"></td>
    </tr>
</table>

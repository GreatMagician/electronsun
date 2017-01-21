<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/header.jsp"/>

<head>
    <script type="text/javascript" src="/electronsun/webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/hide.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/register.js"></script>
    <link rel="stylesheet" href="/electronsun/resources/css/register-style.css">
</head>
<body>
<h1>
    <c:if test="${register}">
        <fmt:message key="app.registerUser"/>
    </c:if>
    <c:if test="${not register}">
        <fmt:message key="app.profile"/>
    </c:if>
</h1>
<div class="error-register">
    <c:if test="${not empty error}">
        ${error}
    </c:if>
</div>
<form:form method="post"  commandName="newUser"
           action="${register ? '/electronsun/register': '/electronsun/users/profile'}"
           charset="utf-8" accept-charset="UTF-8">
    <table>
        <tr>
            <td><p><fmt:message key="users.nick"/></p></td>
            <td><form:input path="name" type="text" id="nick" minlength="3" maxlength="50"
                        onkeyup="checkParams()"
                        value="${newUser.getName()}" /></td>
            <td><div id="errorNick"></div></td>
        </tr>
        <tr>
            <td><p><fmt:message key="users.email"/></p></td>
            <td><form:input  type="email" id="email" value="${newUser.getEmail()}"
                        path="email" onkeyup="checkParams()" /></td>
            <td><div id="errorEmail"></div></td>
        </tr>
        <tr>
            <td><p><fmt:message key="users.firstName"/></p></td>
            <td><form:input type="text" id="name" minlength="3" maxlength="50"
                       value="${newUser.getFirstName()}" path="firstName"/></td>
            <td><div id="errorFirstName"></div></td>
        </tr>
        <tr>
            <td><p><fmt:message key="users.lastName"/></p></td>
            <td><form:input type="text" id="lastName" minlength="3" maxlength="50"
                       value="${newUser.getLastName()}" path="lastName"/></td>
            <td><div id="errorLastName"></div></td>
        </tr>
        <tr>
            <td><p><fmt:message key="users.address"/></p></td>
            <td><form:input type="text"  value="${newUser.getAddress()}" path="address"/></td>
        </tr>
        <tr>
            <td><p><fmt:message key="users.password"/></p></td>
            <td><form:input type="password" minlength="5" maxlength="200" id="pass"
                       onkeyup="checkParams()"
                       value="${newUser.getPassword()}"  path="password"/></td>
            <td><div id="errorPassword"></div></td>
        </tr>
        <tr>
            <td><p><fmt:message key="users.dPassword"/></p></td>
            <td><input type="password" id="repPass" value="${newUser.getPassword()}" required
                       onkeyup="checkParams()" name="password_dubl"></td>
            <td><div id="errorPass"></div></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit" id="submit" name="save" value="true" disabled> <fmt:message key="app.save"/></button>
                <button type="button" id="submit2"  name="save" value="false" onClick="index()"> <fmt:message key="app.cancel"/></button>
            </td>
        </tr>
    </table>
</form:form>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>

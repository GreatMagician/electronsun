<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script type="text/javascript" src="/electronsun/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/electronsun/resources/js/hide.js"></script>
    <link rel="stylesheet" href="/electronsun/resources/css/login-style.css">
</head>
<jsp:include page="fragments/header.jsp"/>

<body>
<h1>Авторизация пользователя</h1>
<div class="error-login">
    <c:if test="${not empty error}">
        ${error}
    </c:if>
</div>
<c:if test="${register}">
    <h2><fmt:message key="app.registered"/></h2>
</c:if>
    <form:form method="post"  name="form_login" action="spring_security_check">
       <table>
           <tr>
               <td><p>email</p></td>
               <td><input  type="email"  required name="email_login"></td>
           </tr>
           <tr>
               <td><p>пароль</p></td>
               <td><input type="password" required name="password_login"></td>
           </tr>
           <tr>
               <td></td>
               <td><button type="submit"> <fmt:message key="app.login"/></button></td>
           </tr>
       </table>
    </form:form>
<jsp:include page="fragments/footer.jsp"/>
</body>
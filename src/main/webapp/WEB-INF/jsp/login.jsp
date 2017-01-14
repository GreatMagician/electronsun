<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="fragments/header.jsp"/>

<head>
    <script type="text/javascript" src="/electronsun/resources/js/hide.js"></script>
    <link rel="stylesheet" href="/electronsun/resources/css/login-style.css">
</head>

<body>
<h1><fmt:message key="app.authorize"/></h1>
<div class="error-login">
    <c:if test="${not empty error}">
        ${error}
    </c:if>
</div>
<c:if test="${register}">
    <h3><fmt:message key="app.registered"/></h3>
</c:if>
    <form:form method="post"  name="form_login" action="spring_security_check">
       <table>
           <tr>
               <td><p><fmt:message key="users.email"/></p></td>
               <td><input  type="email"  required name="email_login"></td>
           </tr>
           <tr>
               <td><p><fmt:message key="users.password"/></p></td>
               <td><input type="password" required name="password_login"></td>
           </tr>
           <tr>
               <td></td>
               <td>
                   <button type="submit"> <fmt:message key="app.login"/></button>
               </td>
           </tr>
           <tr>
               <td></td>
               <td><a class="registerLink" href="#"><fmt:message key="app.notpass"/> </a></td>
           </tr>
           <tr>
               <td></td>
               <td>
                   <a class="registerLink" href="/electronsun/register"><fmt:message key="app.register"/> </a>
               </td>
           </tr>
       </table>
    </form:form>
<jsp:include page="fragments/footer.jsp"/>
</body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
</head>
<div  class="login-container">
    <form:form method="post"  role="form" action="login">
        <input  type="email"  placeholder="email" id="email"> <br/>
        <input type="password" placeholder="пароль" id="password">
        <button type="submit"> <fmt:message key="app.login"/></button>
    </form:form>

</div>

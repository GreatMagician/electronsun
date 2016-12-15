<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="header-background">
    <div class="header-title">
       <label><fmt:message key="app.title"/></label>
    </div>
        <div class="logout-block">
            <form:form method="post"  role="form" modelAttribute="/users" id="login">
                <input  type="email"  placeholder="email" id="email">
                <input type="password" placeholder="пароль" id="password">
                <button type="submit"> <fmt:message key="app.login"/></button>
            </form:form>
            <a href="register"><fmt:message key="app.register"/> </a>
        </div>
</div>
    <%--Меню--%>
<ul class="main-menu">
    <li><a href="#company"><fmt:message key="menu.main"/></a></li>
    <li><a href="#services"><fmt:message key="menu.project"/></a></li>
    <li><a href="#team"><fmt:message key="menu.play"/></a></li>
    <li><a href="#contacts"><fmt:message key="menu.lightShow"/></a></li>
    <li><a href="#contacts"><fmt:message key="menu.device"/></a></li>
</ul>

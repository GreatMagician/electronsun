<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sppring" uri="http://www.springframework.org/tags/form" %>

<div class="header-background">
    <div class="header-title">
       <label><fmt:message key="app.title"/></label>
    </div>
        <c:if test="${user.isNew()}">
            <div class="logout-block">
                <form:form method="post"  role="form" action="users/login" id="login">
                    <input  type="email"  placeholder="email" name="email">
                    <input type="password" placeholder="пароль" name="password">
                    <button type="submit"> <fmt:message key="app.login"/></button>
                </form:form>
                <a class="registerLink" href="/electronsun/register"><fmt:message key="app.register"/> </a>
            </div>
        </c:if>
        <c:if test="${!user.isNew()}">
            <div class="logout-block">
                <form:form method="post"  role="form" action="logout">
                    <a class="prof" href="/electronsun/profile/profile">${user.getName()}</a>
                    <button type="submit"> <fmt:message key="app.logout"/></button>
                </form:form>
            </div>
        </c:if>
</div>
    <%--Меню--%>
<ul class="main-menu">
    <li><a href="/electronsun/index"><fmt:message key="menu.main"/></a></li>
    <li><a href="project"><fmt:message key="menu.project"/></a></li>
    <li><a href="player"><fmt:message key="menu.play"/></a></li>
    <li><a href="shows"><fmt:message key="menu.lightShow"/></a></li>
    <li><a href="devices"><fmt:message key="menu.device"/></a></li>
</ul>

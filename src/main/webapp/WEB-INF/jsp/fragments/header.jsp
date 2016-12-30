<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sppring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="headTag.jsp"/>

<div class="header-background">
    <div class="header-title">
       <label><fmt:message key="app.title"/></label>
    </div>
        <c:if test="${empty user}">
            <div class="logout-block">
                <form:form method="post"  action="spring_security_check">
                    <input  type="email"  placeholder="email" name="email_login">
                    <input type="password" placeholder="пароль" name="password_login">
                    <button type="submit"> <fmt:message key="app.login"/></button>
                </form:form>
                <a class="registerLink" href="/electronsun/register"><fmt:message key="app.register"/> </a>
            </div>
        </c:if>
        <form:form  action="logout" method="post">
            <sec:authorize access="isAuthenticated()">
                <div class="logout-block">
                    <a class="prof" href="/electronsun/users/profile">${user.getName()}</a>
                    <button type="submit"> <fmt:message key="app.logout"/></button>
                </div>
            </sec:authorize>
        </form:form>
</div>
    <%--Меню--%>
<ul class="main-menu">
    <li><a href="/electronsun/index"><fmt:message key="menu.main"/></a></li>
    <li><a href="project"><fmt:message key="menu.project"/></a></li>
    <li><a href="player"><fmt:message key="menu.play"/></a></li>
    <li><a href="shows"><fmt:message key="menu.lightShow"/></a></li>
    <li><a href="devices"><fmt:message key="menu.device"/></a></li>
</ul>

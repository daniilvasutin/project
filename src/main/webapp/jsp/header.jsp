<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<header class="cf">
    <nav>

        <ul id="ulForUserName">

            <a id="enteredUserName" href="EnterByAName">
                <c:if test="${sessionScope.sessionUsername != null}">
                    <c:out value="${sessionScope.sessionUsername}"/>
                </c:if>
            </a>
        </ul>

        <ul id="ulForEnterAndRegist">
            <li id="login">
                <a id="login-trigger" href="#">
                    Sign in <span>&#x25BC;</span>
                </a>
                <div id="login-content">
                    <form id="fromForEnterInHeaderPanel" action="Enter" method="post">
                        <fieldset id="inputs">
                            <input id="nameInHeaderPanel" type="text" name="nameInHeaderPanel" placeholder="Write your name" required>
                            <input id="passwordInHeaderPanel" type="password" name="passwordInHeaderPanel" placeholder="Write your password" required>
                        </fieldset>
                        <fieldset id="actions">
                            <input type="submit" id="submit" value="Sign up">
                            <label><input type="checkbox" checked="checked"> Remember me</label>
                        </fieldset>
                    </form>
                </div>
            </li>
            <li id="signup">
                <a id="aForRegistHeaderPanel" href="#">Registration</a>
                <%--<a onclick="showContent('POST','../jsp/registration.jsp')" href="#">Регистрация</a>--%>
            </li>
        </ul>
    </nav>
</header>
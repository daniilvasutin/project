<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<header class="cf">
    <nav>

        <ul id="ulForUserName">

            <a id="enteredUserName" href="../jsp/privateOffice.jsp">
                <%
                    String username = (String) session.getAttribute("sessionUsername");
                    if (username != null)  {
                        out.println(username);
                    }
                %>
            </a>
        </ul>

        <ul id="ulForEnterAndRegist">
            <li id="login">
                <a id="login-trigger" href="#">
                    Sign in <span>&#x25BC;</span>
                </a>
                <div id="login-content">
                    <form>
                        <fieldset id="inputs">
                            <input id="emailInHeaderPanel" type="email" name="emailInHeaderPanel" placeholder="Write your email" required>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<header class="cf">
<nav>
    <ul>
        <li id="login">
            <a id="login-trigger" href="#">
                Войти <span>&#x25BC;</span>
            </a>
            <div id="login-content">
                <form>
                    <fieldset id="inputs">
                        <input id="userName" type="email" name="Email" placeholder="Write your email" required>
                        <input id="password" type="password" name="Password" placeholder="Write your password" required>
                    </fieldset>
                    <fieldset id="actions">
                        <input type="submit" id="submit" value="Sign in">
                        <label><input type="checkbox" checked="checked"> Remember me</label>
                    </fieldset>
                </form>
            </div>
        </li>
        <li id="signup">
            <a onclick="sendRequest('POST','../jsp/registration.jsp')" href="#">Регистрация</a>
        </li>
    </ul>
</nav>
</header>
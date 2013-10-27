<%--
  Created by IntelliJ IDEA.
  User: jahoope1
  Date: 10.08.13
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
        <form action = "MyServlet" method="post">
            User name: <input name="userName" /><br>
            Full name: <input name="fullName" /><br>
            Experience:<br>
            <input type="radio" name="experience" value="Developer">Developer</input>
            <input type="radio" name="experience" value="Architect">Architect</input>
            <input type="radio" name="experience" value="Tester">Tester</input><br>
            Profession:
            <select name="profession">
                <option value="Junior">Junior</option>
                <option value="Middle">Middle</option>
                <option value="Senior">Senior</option>
            </select><br>
            <input type="submit">
        </form>
</body>
</html>
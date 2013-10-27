<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: jahoope1--%>
  <%--Date: 28.08.13--%>
  <%--Time: 11:17--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>QA-assistant</title>--%>
    <%--<meta charset="utf-8">--%>
    <%--<link rel="stylesheet" type="text/css" href="../css/headerCss.css" />--%>

    <%--<!--[if lt IE 9]>--%>
    <%--<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>--%>
    <%--<![endif]-->--%>

    <%--<script src="../js/jquery.min.js"></script>--%>
    <%--<script src="../js/myScript.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
    <%--<jsp:include page="header.jsp"/>--%>
    <form action = "MyServlet" method="post" class="formClass">
        <table id="tableRegistrForm">
            <tr>
                <td><label>User name:</label></td><td><input id="userName" type="text" name="userName" placeholder="Write your  name" required></td>
            </tr>
            <tr>
                <td><label>Password:</label></td><td><input id="password" type="password" name="password" placeholder="Write your password" required></td>
            </tr>
            <tr>
                <td><label>Email:</label></td><td><input id="email" type="email" name="email" placeholder="Write your email" required></td>
            </tr>
            <tr>
                <td><label>Role:</label></td>
                <td>
                    <select name="role">
                        <option value="Owner">Owner</option>
                        <option value="Admin">Admin</option>
                        <option value="Leader">Leader</option>
                        <option value="Tester">Tester</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input id="tableRegistFormSignUp" type="submit" value="Sign up"></td>
            </tr>
        </table>
    </form>
<%--</body>--%>
<%--</html>--%>
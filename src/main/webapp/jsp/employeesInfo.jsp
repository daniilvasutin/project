<%@ page import="main.java.dto.Users" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: jahoope1
  Date: 10.08.13
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h3>Users information</h3>

    <%
        List<Object[]> employees = (List<Object[]>) request.getAttribute("listOfEmployees");
        for(Object[] employee : employees){
            String name = (String) employee[0];
            String password = (String) employee[1];
            String email = (String) employee[2];
            String role = (String) employee[3];
    %>
    User #<%=employees.indexOf(employee)%><br>
    User Name: <%=name%> <br>
    Password: <%=password%> <br>
    Email: <%=email%> <br>
    Role: <%=role%> <br>
    <%}%>

</body>
</html>
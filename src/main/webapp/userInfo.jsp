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
        List<Users> users = (List<Users>) request.getAttribute("listOfUsers");
        for(int i = 0; i < users.size(); i++){
    %>
    User #<%=i%><br>
    User Name: <%=users.get(i).getUserName()%> <br>
    Foll Name: <%=users.get(i).getFullName()%> <br>
    Experience: <%=users.get(i).getExperience()%> <br>
    Profession: <%=users.get(i).getProfession()%> <br><br>
    <%}%>

</body>
</html>
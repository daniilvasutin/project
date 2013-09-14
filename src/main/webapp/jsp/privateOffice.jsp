<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html id="indexhtml">
<head>
    <title>QA-assistant</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/headerCss.css" />
    <link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.10.3.custom.css" />

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <script src="../js/jqueryLib.js"></script>
    <script src="../js/myScript.js"></script>
    <script src="../js/jquery-ui-1.10.3.custom.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#tabs").tabs({
                load: function(ui){
                    ui.panel.html("loading");
                }
            });
        });
    </script>

</head>

<body id="bodyid">
<jsp:include page="header.jsp"/>

<%--<div id="contentPane">IT'S HELLO</div>--%>
<%--<div id="container">--%>

<div id="fullSiteContentDiv">
    <div id="SiteContentUserInfo">
        <div id="SiteContentUsernameDiv">
            <%=session.getAttribute("sessionUsername").toString()%>
        </div>
        <hr size="2" width="165"/>
        <div id=SiteContentUserStatistic>
            <div id="SiteContentUserProjectCount">
                13
            </div>
            <div id="SiteContentUserCompanyCount">
                2
            </div>
            <div id="SiteContentUserTestCount">
                56
            </div>
        </div>
        <hr size="2" width="165" style="margin-top: 25px"/>
        <div id="SiteContetntStatisticNameDiv">
            <dive id="SiteContetntStatisticNameProject">
                Project
            </dive>
            <dive id="SiteContetntStatisticNameCompany">
                Company
            </dive>
            <dive id="SiteContetntStatisticNameTest">
                Test
            </dive>
        </div>
    </div>
    <div id="SiteContentDifferentInfo">
        <div id="tabs">
            <ul>
                <li><a href="#tabs-1">Company</a></li>
                <li><a href="../jsp/registration.jsp">Project</a></li>
            </ul>
            <div id="tabs-1">
                <p id="Yourlistofcompaniesisempty">Your list of companies is empty! <a id="addCompany" href="#">Add company.</a></p>
                <div id="addCompanyDiv" >

                </div>
            </div>
            <div id="tabs-2">

            </div>
        </div>

        <p>Please enter all fields in order to add a company</p>
        <form id="formForRegistCompany" >

            <table id="tableRegistrFormCompany">
                <tr>
                    <td><label>Company name:</label></td><td><input id="registFormCompanyName" type="text" name="registFormCompanyName" placeholder="Write campnay name" required></td>
                </tr>
                <tr>
                    <td><label>Details:</label></td><td><textarea rows="6" cols="45" id="registFormCompanyDetails" name="registFormCompanyDetails" placeholder="Write company details" style="border-color: #646464;"></textarea></td>
                </tr>
                <tr>
                    <td><input type="button" value="Add company" id="formForRegistCompanySubmit"></td>
                    <%--<td><input type="submit" value="Add company"></td>--%>
                </tr>
            </table>

        </form>

    </div>

</div>

<%--</div>--%>


<%--<div style="position:relative;" id="dopoln_block">--%>
<%--<div style="background:#66AAD7; width:200px; position: absolute; top:10px; left:10px;">2<br>текст</div>--%>
<%--</div>--%>

<%--<div style="background:#FA911D; width:240px; float:left;">1</div>--%>
<%--<div style="background:#0080C0; width:150px; float:left; ">2<br>text<br>text</div>--%>
<%--<div style="background:#80FF00; width:130px; float:left;">3<br>текст</div>--%>
<%--<div style="background:#36E065; clear:left;">4<br>контент<br>контент<br>контент</div>--%>

<div id="loading" style="display: none">Please wait, loading...</div>



</body>
</html>
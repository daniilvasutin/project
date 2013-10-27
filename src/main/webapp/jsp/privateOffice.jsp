<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="main.java.dto.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.dto.Project" %>
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

    <%--<script src="http://code.jquery.com/jquery-1.9.1.js"></script>--%>
    <script src="../js/jquery-2.0.3.js"></script>
    <script src="../js/myScript.js"></script>
    <script src="../js/jquery-ui-1.9.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#tabs").tabs({
                select: function(event, ui) {
                    window.location.hash = ui.tab.hash;
                }
            });
        });
    </script>

</head>

<body id="privateOfficeBodyId">
<jsp:include page="header.jsp"/>


<div id="fullSiteContentDiv">
    <div id="SiteContentUserInfo">
        <div id="SiteContentUsernameDiv">
            <c:if test="${sessionScope.sessionUsername != null}">
                <c:out value="${sessionScope.sessionUsername}"/>
            </c:if>
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
        <div id="tabs" class="containerForTabs">
            <ul>
                <li><a href="#tabs-1">Company</a></li>
                <li><a href="#tabs-2">Project</a></li>
            </ul>
            <div id="tabs-1">
                <div id="listOfCompany" class="panelForTabs">
                    <c:choose>
                        <c:when test="${fn:length(requestScope.companies) == 0}">
                            <p id="Yourlistofcompaniesisempty">Your list of companies is empty! <a class="addCompanyA" href="#">Add company.</a></p>
                        </c:when>
                        <c:otherwise>
                            <c:set scope="session" var="companies" value="${requestScope.companies}" />
                            <p>It's the company you work for: </p>
                            <table id="tableOfCompany">
                                <c:forEach var="company" items="${requestScope.companies}" varStatus="status">
                                    <tr>
                                        <td>Company # <c:out value="${status.count}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Name: <a href="#tabs-2" id="linkToShowCompanyProjectId<c:out value='${company.companyId}'/>"
                                                     class="linkToShowCompanyProject"><c:out value="${company.name}"/></a>
                                        </td>
                                        <td>Dateils: <c:out value="${company.deteils}"/></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <p id="Yourlistofcompaniesisempty">Do you want add company? <a class="addCompanyA" href="#">Add company.</a></p>
                        </c:otherwise>
                    </c:choose>
                    <div id="addCompanyDiv"></div>
                </div>
            </div>
            <div id="tabs-2">
                <div id="listOfProject" class="panelForTabs">

                    <c:choose>
                        <c:when test="${fn:length(requestScope.projects) == 0}">
                            <p id="Yourlistofprojectisempty">Your list of projects is empty! <a class="addProjectA" href="#">Add project.</a></p>
                        </c:when>
                        <c:otherwise>
                            <p>It's the project of <c:out value="${requestScope.companies[fn:length(requestScope.companies)-1].name}"/> company: </p>
                            <table id="tableOfProject">
                            <c:forEach var="project" items="${requestScope.projects}" varStatus="status">
                                <tr>
                                    <td>Project # <c:out value="${status.count}"/></td>
                                </tr>
                                <tr>
                                    <td>Name: <a href="#tabs-2" id="<c:out value='${project.projectId}'/>"><c:out value="${project.name}"/></a></td>
                                    <td>Company: <c:out value="${project.company.name}"/></td>
                                </tr>
                            </c:forEach>
                            </table>
                            <p id="Yourlistofprojectisempty">Do you want add project? <a class="addProjectA" href="#">Add project.</a></p>
                        </c:otherwise>
                    </c:choose>
                    <div id="addProjectDiv"></div>
                </div>
            </div>
        </div>
    </div>

</div>

<div id="loading" style="display: none">Please wait, loading...</div>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.dto.Company" %>
<p>Please enter all fields in order to add a test plan</p>
<form id="formForRegistTestPlan" >

    <table id="tableRegistrFormTestPlan">
        <tr>
            <td><label>Test plan name:</label></td><td><input id="registFormTestPlanName" type="text" name="registFormTestPlanName" placeholder="Write test plan name" required></td>
        </tr>
        <tr><td><label>Begin date:</label></td><td><input id="registFormTestPlanBeginDate" type="text" name="registFormTestPlanBeginDate" placeholder="Write test plan begin date" required></td></tr>
        <tr><td><label>End date:</label></td><td><input id="registFormTestPlanEndDate" type="text" name="registFormTestPlanEndDate" placeholder="Write test plan end date" required></td></tr>
        <tr>
            <td><label>Name of project:</label></td>
            <td>
                <select name="registFormTestPlanNameOfProject" id="registFormTestPlanNameOfProject">
                    <c:choose>
                        <c:when test="${fn:length(sessionScope.projects) == 0}">
                            <option value="Empty">No projects</option>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="project" items="${sessionScope.projects}">
                                <option value="<c:out value='${project.projectId}'/>"><c:out value="${project.name}"/></option>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </select>
            </td>
            <%--<td><label>Num of company:</label></td><td><input id="registFormProjectCompany" type="text" name="registFormProjectCompany" placeholder="Write id company" required></td>--%>
        </tr>
        <tr>
            <td><input type="submit" value="Add test plan"></td>
            <%--<td><input type="button" value="Add company" id="formForRegistCompanySubmit"></td>--%>
        </tr>
    </table>

</form>
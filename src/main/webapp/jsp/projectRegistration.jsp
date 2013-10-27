<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="main.java.dto.Company" %>
<p>Please enter all fields in order to add a project</p>
<form id="formForRegistProject" >

    <table id="tableRegistrFormProject">
        <tr>
            <td><label>Project name:</label></td><td><input id="registFormProjectName" type="text" name="registFormProjectName" placeholder="Write project name" required></td>
        </tr>
        <tr>
            <td><label>Name of company:</label></td>
            <td>
                <select name="registFormProjectNameOfCompany" id="registFormProjectNameOfCompany">
                    <c:choose>
                        <c:when test="${fn:length(sessionScope.companies) == 0}">
                            <option value="Empty">No company</option>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="company" items="${sessionScope.companies}">
                                <option value="<c:out value='${company.companyId}'/>"><c:out value="${company.name}"/></option>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </select>
            </td>
            <%--<td><label>Num of company:</label></td><td><input id="registFormProjectCompany" type="text" name="registFormProjectCompany" placeholder="Write id company" required></td>--%>
        </tr>
        <tr>
            <td><input type="submit" value="Add project"></td>
            <%--<td><input type="button" value="Add company" id="formForRegistCompanySubmit"></td>--%>
        </tr>
    </table>

</form>
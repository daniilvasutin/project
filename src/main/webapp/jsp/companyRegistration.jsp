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
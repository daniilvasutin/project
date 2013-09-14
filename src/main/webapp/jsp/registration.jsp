<form id="formForRegist" method="post" action="/MyServlet">

    <table id="tableRegistrForm">
        <tr>
            <td><label>User name:</label></td><td><input id="registFormUserName" type="text" name="registFormUserName" placeholder="Write your  name" required></td>
        </tr>
        <tr>
            <td><label>Password:</label></td><td><input id="registFormPassword" type="password" name="registFormPassword" placeholder="Write your password" required></td>
        </tr>
        <tr>
            <td><label>Email:</label></td><td><input id="registFormEmail" type="email" name="registFormEmail" placeholder="Write your email" required></td>
        </tr>
        <tr>
            <td><label>Role:</label></td>
            <td>
                <select name="registFormRole" id="registFormRole">
                    <option value="Owner">Owner</option>
                    <option value="Admin">Admin</option>
                    <option value="Leader">Leader</option>
                    <option value="Tester">Tester</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Sign up"></td>
            <%--<td><input type="button" value="Sign up" id="formForRegistSubmit"></td>--%>
            <td><input type="checkbox" id="enterAfterRegist" name="enterAfterRegist" value="checked" checked />Automatically enter<br></td>
        </tr>
    </table>

</form>
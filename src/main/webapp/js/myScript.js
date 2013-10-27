$(document).ready(function(){

    $('#login-trigger').click(function(){
        $(this).next('#login-content').slideToggle();
        $(this).toggleClass('active');

        if ($(this).hasClass('active')) $(this).find('span').html('&#x25B2;')
        else $(this).find('span').html('&#x25BC;')
    });

    if($('#enteredUserName').text().trim().length > 0){
        $('#ulForUserName').css({paddingLeft:'9px',paddingRight:'9px'});
    }

//    $('#indexBodyId').on("click","#formForRegist input:submit",function() {
//        alert("form");
//        var data = new Array($('#registFormUserName').val(),
//            $('#registFormPassword').val(),
//            $('#registFormEmail').val(),
//            $('#registFormRole').val());
//
//        var enterAfeterRegist = false;
//        if($('#cbEnterAfterRegist').attr("checked") == 'checked'){
//            enterAfeterRegist = true;
////            alert(enterAfeterRegist);
//        }
//
//        $.post('MyServlet', {username: data[0],
//            password: data[1],
//            email: data[2],
//            role: data[3],
//            enter: enterAfeterRegist},
//            function(){
////                window.location.replace("jsp/privateOffice.jsp");
////                window.location = "jsp/privateOffice.jsp";
////                $("#contentPane").html(data);
////            function(responseJson) {
////                var $ul = $('<ul>').appendTo($('#contentPane'));
////                $.each(responseJson, function(index, item) {
////                    $('<li>').text(item).appendTo($ul);
////                });
//            }
//        );
//        event.preventDefault();//for stop default work of button with type=submit
//    });

    $('#aForRegistHeaderPanel').on("click",function(){
//        alert("hello");
        $.ajax({
            url: "../jsp/registration.jsp",
            cache: false,
            success: function(html){
                $("#contentPane").html(html);
            }
        });
    });

    $('.addCompanyA').on("click",function(){
        $('#Yourlistofcompaniesisempty').hide(400);
        $('#addCompanyDiv').hide();

        $.ajax({
            url: "../jsp/companyRegistration.jsp",
            cache: false,
            success: function(html){
                $("#addCompanyDiv").html(html);
                $('#listOfCompany').animate({ scrollTop: $('#listOfCompany')[0].scrollHeight - $('#listOfCompany').height()  }, 'slow');
            }
        });

        $('#addCompanyDiv').fadeIn(1000);
    });

    $('#privateOfficeBodyId').on("click","#formForRegistCompany input:submit",function() {

        var data = new Array($('#registFormCompanyName').val(),
            $('#registFormCompanyDetails').val());

        $.post('AddCompany',{companyName: data[0],
                companyDetails: data[1]},
            function(responseJson) {

//                location.hash = "/privateOffice.jsp";

                var $table = $('#tableOfCompany').after();
                var $tr1 = $('<tr>').appendTo($table).hide();
                $('<td>').text("Company # " + responseJson[0]).appendTo($tr1);
                var $tr2 = $('<tr>').appendTo($table).hide();
                $('<td>').text("Name: " + responseJson[1]).appendTo($tr2);
                $('<td>').text("Details: " + responseJson[2]).appendTo($tr2);

                $tr1.fadeIn(1000);
                $tr2.fadeIn(1000);

            });
        event.preventDefault();
    });

    $('#privateOfficeBodyId').on("click",".addProjectA",function(){
        $('#Yourlistofprojectisempty').hide(400);
        $('#addProjectDiv').hide();

        $.ajax({
            url: "../jsp/projectRegistration.jsp",
            cache: false,
            success: function(html){
                $("#addProjectDiv").html(html);
                $('#listOfProject').animate({ scrollTop: $('#listOfProject')[0].scrollHeight - $('#listOfProject').height()  }, 'slow');
            }
        });

        $('#addProjectDiv').fadeIn(1000);
    });

    $('#privateOfficeBodyId').on("click","#formForRegistProject input:submit",function() {

        var data = new Array($('#registFormProjectName').val(),
            $('#registFormProjectNameOfCompany').val());

        $.post('AddProject',{projectName: data[0],
                projectCompanyId: data[1]},
            function(responseJson) {

                var $table = $('#tableOfProject').last();
                var $tr1 = $('<tr>').appendTo($table).hide();
                $('<td>').text("Project # " + responseJson[0]).appendTo($tr1);
                var $tr2 = $('<tr>').appendTo($table).hide();
                $('<td>').text("Name: " + responseJson[1]).appendTo($tr2);
                $('<td>').text("Company: " + responseJson[2]).appendTo($tr2);

                $tr1.fadeIn(1000);
                $tr2.fadeIn(1000);

            });

        event.preventDefault();
    });

    $('.linkToShowCompanyProject').click(function() {
        $('#tabs').tabs('select', 1);

        var thenum = this.id.replace( /^\D+/g, '');

        $.ajax({
            url: 'ShowCompanyProject',
            type: 'POST',
            dataType: 'json',
            data: {companyProjectId: thenum},
            success: function(responseJson) {
                $('#listOfProject').html("");

                var str = "<p>It\'s the project of " + responseJson[0].companyName + " company: </p>";
                var $ItsTheProjectOf = document.createElement("div");
                $ItsTheProjectOf.innerHTML = str;
                $('#listOfProject').append($ItsTheProjectOf);// to $('#listOfProject') append $ItsTheProjectOf


                var $table = $('<table>').appendTo($ItsTheProjectOf);// to $ItsTheProjectOf append $('<table>')
//                var $table = $('<table>').appendTo($('#listOfProject'));
                $.each(responseJson, function(index, project) {

                    var $tr1 = $('<tr>').appendTo($table).hide();
                    $('<td>').text("Project # " + (index+1)).appendTo($tr1);
                    var $tr2 = $('<tr>').appendTo($table).hide();
                    $('<td>').html("Name: " + '<a href="../jsp/hello.jsp" id="' + project.projectId + '">' + project.name + '</a>').appendTo($tr2);
                    $('<td>').text("Company: " + project.companyProject).appendTo($tr2);

                    $tr1.fadeIn("fast");
                    $tr2.fadeIn("fast");
                });

                var $WantToAddProject = $("<p id='Yourlistofprojectisempty'>Do you want add project? <a class='addProjectA' href='#'>Add project.</a></p>");
                $table.after($WantToAddProject);//no append because append add $WantToAddProject as next row in to table, after - add tag $WantToAddProject after tag </table>
                var $addProjectDiv = $("<div id='addProjectDiv'></div>");
                $WantToAddProject.after($addProjectDiv);//no append because append add $addProjectDiv to the end of teg <p>, after set tag $addProjectDiv after tag $WantToAddProject ---> after it's like appendChild

//                var str = "<p id='Yourlistofprojectisempty'>Do you want add project? <a class='addProjectA' href='#'>Add project.</a></p>";
//                var $WantToAddProject = document.createElement("div");
//                $WantToAddProject.id = "WantToAddProjectId";
//                $WantToAddProject.innerHTML = str;
//
//                $table.after($WantToAddProject);//no append because append add $WantToAddProject as next row in to table, after - add tag $WantToAddProject after tag </table>
//
//                var $addProjectDiv = document.createElement("div");
//                $addProjectDiv.id = "addProjectDiv";
//
//                $WantToAddProject.appendChild($addProjectDiv);
            }
        });
    });


    $('#tablink').click(function() {
        $('#tabs').tabs('select', 1);
        return false;
    });

//    $( "#tabs" ).tabs({
//        activate: function( event, ui ) {
//            alert("hello");
//        }
//    });

});

////создание ajax объекта
//function createRequestObject()
//{
//    try { return new XMLHttpRequest() }
//    catch(e)
//    {
//        try { return new ActiveXObject('Msxml2.XMLHTTP') }
//        catch(e)
//        {
//            try { return new ActiveXObject('Microsoft.XMLHTTP') }
//            catch(e) { return null; }
//        }
//    }
//}
//
//function showContent(method,URL) {
//
//    var cont = document.getElementById('contentPane');
//    var loading = document.getElementById('loading');
//
//    cont.innerHTML = loading.innerHTML;
//
//    var http = createRequestObject();
//    if( http ){
//        http.open(method, URL);
//        http.onreadystatechange = function(){
//            if(http.readyState == 4 && http.status == 200){
//                cont.innerHTML = http.responseText;
//
//                var elements = document.getElementById('indexhtml').getElementsByTagName('script');
//                var len = elements.length;
//                for (var i = 0; i < len; i++) {
//                eval.call(window, elements[i].innerHTML);
//            }
//            }
//        }
//        http.send(null);
//    }
//    else{
//        document.location = URL;
//    }
//}
//
//function showContent() {
//    $.ajax({
//        url: "../jsp/registration.jsp",
//        cache: false,
//        success: function(html){
//            $("#contentPane").html(html);
//        }
//    });
//}
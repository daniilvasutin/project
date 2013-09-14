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

//    $('#formForRegist').on("submit",function() {
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
//        $.get('MyServlet', {username: data[0],
//            password: data[1],
//            email: data[2],
//            role: data[3],
//            enter: enterAfeterRegist},
//            function(data){
//                $("#contentPane").html(data);
////            function(responseJson) {
////            var $ul = $('<ul>').appendTo($('#contentPane'));
////            $.each(responseJson, function(index, item) {
////                $('<li>').text(item).appendTo($ul);
////            });
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

    $('#addCompany').on("click",function(){
        $('#addCompany').hide();
        $('#Yourlistofcompaniesisempty').hide(400);

        $.ajax({
            url: "../jsp/companyRegistration.jsp",
            cache: false,
            success: function(html){
                $("#addCompanyDiv").html(html);
            }
        });

        $('#addCompanyDiv').fadeIn(1000);
    });


    $('#bodyid').on("click","#formForRegistCompanySubmit",function() {
//        alert("submit");
        var data = new Array($('#registFormCompanyName').val(),
            $('#registFormCompanyDetails').val());
        alert(data[0] + data[1]);

        $.get('MyServlet', {comanyName: data[0],
                deteils: data[1]},
            function(data){
                $("#addCompanyDiv").html(data);
                alert('Load was performed.');
//            function(responseJson) {
//                alert("hello");
//                var $ul = $('<ul>').appendTo($('#addCompanyDiv'));
//                $.each(responseJson, function(index, item) {
//                    $('<li>').text(item).appendTo($ul);
//                });
            }
        );
//        event.preventDefault();//for stop default work of button with type=submit
    });


//    $('#SiteContentUsernameDiv').click(function(){
//       alert("hello");
//    });
//
//    $('#registFormUserName').on("click",function(){
//        alert("hello");
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

//function showContent() {
//    $.ajax({
//        url: "../jsp/registration.jsp",
//        cache: false,
//        success: function(html){
//            $("#contentPane").html(html);
//        }
//    });
//}
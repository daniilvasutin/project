//    $('#formForRegist').live("submit",function(event) {
//
//        var data = new Array($('#registFormUserName').val(),
//            $('#registFormPassword').val(),
//            $('#registFormEmail').val(),
//            $('#registFormRole').val());
//
//        $.get('MyServlet',{user:data[0],
//            password:data[1],
//            email:data[2],
//            role:data[3]},
//            function(responseText) {
//            $('#contentPane').text(responseText);
//        });
//        event.preventDefault();
//    });

//    $('#formForRegistSubmit').live("click",
//        (function(){
//            alert('All ok!!');
//        $.ajax({
//            url: 'MyServlet',
//            type: 'POST',
//            dataType: 'json',
//            data: $('#formForRegist').serialize(),
//            success: function(data){
//                alert('All ok!!');
//                if(data.isValid){
//                    alert('All ok!!');
//                    $('#contentPane').html('Your name is: ' + data.userName);
//                    $('#contentPane').slideDown(500);
//                }
//                else{
//                    alert('Please enter a valid username!!');
//                }
//            }
//        });
//        return false;
//    }));

//function loadContent(http){
//    if(http.readyState == 4 && http.status == 200){//не работает т.к. теряется http.readyState
//        cont.innerHTML = http.responseText;
//    }
//}

//function createRequestObject(){
//    var req;
//
//    if(window.XMLHttpRequest){req = new XMLHttpRequest();}
//    else if(window.ActiveXObject){req = new ActiveXObject("Microsoft.XMLHTTP");}
//    else{alert('Your browser is not IE 5 or higher, or Firefox or Safari or Opera');}
//
//    return req;
//}
//
//var http = createRequestObject();
//
//function sendRequest(method, url){
//    if(method == 'get' || method == 'GET'
//        || method == 'post' || method == 'POST'){
//        http.open(method,url);
//        http.onreadystatechange = handleResponse;
//        http.send(null);
//    }
//}
//
//function handleResponse(){
//    if(http.readyState == 4 && http.status == 200){
//        var response = http.responseText;
//        if(response){
//            document.getElementById("contentPane").innerHTML = response;
////            var elements = document.getElementById('bodyId').getElementsByTagName('script');
////            var len = elements.length;
////            for (var i = 0; i < len; i++) {
////                eval.call(window, elements[i].innerHTML);
////            }
//        }
//    }
//}


//$('#mybutton').click(function() {                        // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
//    $.get('MyServlet', function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
//        var $ul = $('<ul>').appendTo($('#contentPane')); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
//        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
//            $('<li>').text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
//        });
//    });
//});

//    $('#subUp').live("click",function(event) {
//                alert("hello");
//
//
//    });
//
//    $(document).ready(function(){
//        $('#registFormSubmit').click(function(event) {
//            //        alert("hello");
//            var username=$('#registUserName').val();
//
//            alert(username);
//
//            $.get('MyServlet',{user:username},function(responseText) {
//                $('#contentPane').text(responseText);
//            });
//        });
//    });
//        $('#registFormSubmit').live("click",function(event) {
//            //        alert("hello");
//
//                var username=$('#registUserName').val();
//
//                alert(username);
//
//                $.get('MyServlet',{user:username},function(responseText) {
//            $('#contentPane').text(responseText);
//            });
////            event.preventDefault();
//        });
//
//
//
//    $('#submitForm').click(function(event) {
////        alert("hello");
//        var username=$('#userName').val();
//        var userpass=$('#password').val();
//
//        alert(username);
//        alert(userpass);
//
//        $.get('MyServlet',{user:username},function(responseText) {
//            $('#contentPane').text(responseText);
//        });
//    });
//
//    $('#singup').click(function(){
//        $.ajax({
//            type: "POST",
//            cache:false,
//            url: "../jsp/registration.jsp",
//            success: function(data) {window.location="../jsp/registration.jsp"}
//        })
//    })
//    function loadPage(url){
//        var request = new XMLHttpRequest();
//
//        request.open("GET", url, true);
//
//        request.onreadystatechange = function(){
//            if(request.readyState == 4){
//                document.getElementById('contentPane').innerHTML = request.responseText;
//            }
//        }
//        request.send(null);
//    }
//    $('#subUp').live("click",function(){
//        alert("It's user name");
//    });
//    document.getElementById('#role').onclick = function() {
//        alert("!!!!!!!!111");
//    }
//function myFunction()
//{
//    alert("I am an alert box!");
//}
//    $('#formForRegist').live("submit",
//        (function(){
//        $.ajax({
//            url: 'MyServlet',
//            type: 'POST',
//            dataType: 'json',
//            data: $('#formForRegist').serialize(),
//            success: function(data){
//                alert('All ok!!');
//                if(data.isValid){
//                    alert('All ok!!');
//                    $('#contentPane').html('Your name is: ' + data.userName);
//                    $('#contentPane').slideDown(500);
//                }
//                else{
//                    alert('Please enter a valid username!!');
//                }
//            }
//        });
//        return false;
//    }));

 $('privateOfficeBodyId').bind("load", function() {
//        alert("load");
//
//    });

//    $(document).on('pageinit','#privateOfficeBodyId',function(){
//        alert("load!");
//    });

//    $('#privateOfficeBodyId').on('pageinit',function(){
//        alert("load");
//    });

//    if(window.location == "http://localhost:9090/MyServlet"){
//     alert("load");
//    }

//    alert(window.location);
//    $('#privateOfficeBodyId').bind('pageshow',function(){
//        alert("load");
//    })

//    if($('#privateOfficeBodyId').readyState == 'complete'){
//        alert("hello");
//    }

    $('#inp').click(function(){
        $('#listOfCompany').animate({ scrollTop: $('#listOfCompany')[0].scrollHeight - $('#listOfCompany').height() }, "slow");
    });

    //                h = $("#addCompanyDiv").height();


  //var e = $('#registFormProjectNameOfCompany');
  //var k = e.options[e.selectedIndex].value;

  //    var obj = jQuery.parseJSON( '{ "name": "John" }' );
  //    alert( obj.name);


  console.log("out [] " + responseJson[0].userName + "::" + responseJson[1].userName);
  console.log("out . " + responseJson.userName + "::" + responseJson.experience);
  console.log("p " + project);
  console.debug(". " + project.userName + "::" + project.experience);


//$.post OOOORRRR $.ajax what you want
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

                  var $table = $('<table>').appendTo($('#listOfProject'));

                  $.each(responseJson, function(index, project) {
                      var $tr1 = $('<tr>').appendTo($table).hide();
                      $('<td>').text("Project # " ).appendTo($tr1);
                      var $tr2 = $('<tr>').appendTo($table).hide();
                      $('<td>').text("Name: " + project.name).appendTo($tr2);
                      $('<td>').text("Company: " + project.companyProject).appendTo($tr2);

                      $tr1.fadeIn(1000);
                      $tr2.fadeIn(1000);
                  });
              }
          });

  //        $.post('ShowCompanyProject',
  //            {companyProjectId: thenum},
  //            function(responseJson){
  //                $('#listOfProject').html("");
  //
  //                var $table = $('<table>').appendTo($('#listOfProject'));
  //
  //                $.each(responseJson, function(index, project) {
  //                    var $tr1 = $('<tr>').appendTo($table).hide();
  //                    $('<td>').text("Project # " ).appendTo($tr1);
  //                    var $tr2 = $('<tr>').appendTo($table).hide();
  //                    $('<td>').text("Name: " + project.name).appendTo($tr2);
  //                    $('<td>').text("Company: " + project.companyProject).appendTo($tr2);
  //
  //                    $tr1.fadeIn(1000);
  //                    $tr2.fadeIn(1000);
  //            });
  //        });

      });
//$.post OOOORRRR $.ajax what you want ^
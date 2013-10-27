$(document).ready(function(){
    $('#login-trigger').click(function(){
        $(this).next('#login-content').slideToggle();
        $(this).toggleClass('active');

        if ($(this).hasClass('active')) $(this).find('span').html('&#x25B2;')
        else $(this).find('span').html('&#x25BC;')
    })

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

});
function createRequestObject(){
    var req;
    if(window.XMLHttpRequest){
//For Firefox, Safari, Opera
        req = new XMLHttpRequest();
    }
    else if(window.ActiveXObject){
//For IE 5+
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else{
//Error for an old browser
        alert('Your browser is not IE 5 or higher, or Firefox or Safari or Opera');
    }

    return req;
}

//Make the XMLHttpRequest Object
var http = createRequestObject();

function sendRequest(method, url){
    if(method == 'get' || method == 'GET'
        || method == 'post' || method == 'POST'){
        http.open(method,url);
        http.onreadystatechange = handleResponse;
        http.send(null);
    }
}

function handleResponse(){
    if(http.readyState == 4 && http.status == 200){
        var response = http.responseText;
        if(response){
            document.getElementById("contentPane").innerHTML = response;
        }
    }
}
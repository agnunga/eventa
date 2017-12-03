<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type">
    <title>BroadCaster</title>
    <script src="http://s.codepen.io/assets/libs/modernizr.js"
            type="text/javascript"></script>
    <link rel='stylesheet prefetch'
          href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch'
          href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
    <link rel='stylesheet prefetch'
          href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>
<div class="row">
    <div class="col-xs-offset-0 col-xs-4 col-sm-offset-0 col-sm-4 col-md-offset-4 col-md-4"
         style="border:1px solid gray; border-radius: 10px;">
        <h3 style="text-align: center;">Broadcast Center</h3>
        <!--<div class="box box-primary direct-chat direct-chat-primary">-->
        <div id="incomming" class="direct-chat-messages"> </div>
        <!--</div>-->
        <div class="box-footer" style = "width: 100%;">
            <div class="">
                <input class="form-control" name="phone" value="<%= session.getAttribute("usersession")%>" id="phone"  type="hidden" readonly>
                <textarea id="message" name="message" class="form-control" onKeyDown="if (event.keyCode === 13)
                                    webSocketTest()" style="width:100%;"></textarea>
                <p style="color: grey; font-size: 12px;">
                    Type Message and press Enter...
                </p>
            </div>
        </div>
    </div>
</div>
<script>
    var websocket = new WebSocket("ws:localhost:8080/eventa/wsmessage");
    function webSocketTest() {
        var phone = document.getElementById("phone").value;
        if (phone !== "") {
            websocket.send(phone);
            document.getElementById("phone").value = "";
            document.getElementById("phone").type = "hidden";
        }
        var message = document.getElementById("message").value;
        if (message !== "") {
            document.getElementById("message").value = "";
            websocket.send(message);
        }
    }
    websocket.onmessage = function (e) {
        writeResponse(e.data);
    };
    function writeResponse(text) {
        document.getElementById("incomming").innerHTML += "<br/>" + text;
        var objDiv = document.getElementById("incomming");
        objDiv.scrollTop = objDiv.scrollHeight;
    }
</script>
</body>
</html>

<% if (request.getAttribute("message") != null) {%>
<div class="row">
    <div class="col-sm-offset-2 col-sm-8 alert alert-warning" id="message-alert">
        <button type="button" class="close" data-dismiss="alert">x</button>
        <%=request.getAttribute("message")%>
    </div>
</div>
<script>
    $("#message-alert").fadeTo(500, 500).slideUp(500, function () {
        $("#message-alert").slideUp(500);
    });
</script>
<%}%>

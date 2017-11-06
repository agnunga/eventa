<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/message.jsp"/>
<div class="row">
    <div class="col-md-6">
        <jsp:include page="../forms/login.jsp"/>
    </div>
</div>
<script>
sendAjaxReq("#login_form")
</script>
<jsp:include page="../includes/footer.jsp"/>

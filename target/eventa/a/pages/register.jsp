<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/message.jsp"/>
<div class="row">
    <div class="col-md-6">
        <jsp:include page="../../forms/models/user.jsp"/>
    </div>
</div>
<script src="../scripts/ajaxUtil.js"></script>
<script>
sendAjaxReq("#user_form")
</script>
<jsp:include page="../../includes/footer.jsp"/>

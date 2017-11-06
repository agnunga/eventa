<jsp:include page="../includes/header.jsp"/>
<jsp:include page="../includes/message.jsp"/>
<div class="row">
    <div class="col-md-6">
        <h2>File Upload</h2>
        <form action="process_upload" method="post">
            <input type="file" multiple name="newAttachments"/>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>
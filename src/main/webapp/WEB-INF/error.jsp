<%@ include file="/jsp/header.jsp" %>
<%@page isErrorPage="true" %>
<div style="margin: 20%">
    <h2 style="text-align: left;">
        Sorry! It seems this page ran into a situation it may not recover from:<br/>
    </h2>
    <h3 style="text-align: center;">
        <%= exception%>
    </h3>
</div>
<%@ include file="/jsp/footer.jsp" %>

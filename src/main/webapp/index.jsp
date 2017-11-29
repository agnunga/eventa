<%@ include file="/jsp/header.jsp" %>

<div class="row">
    <%--<div class="col-md-3">--%>
    <%--<jsp:include page="/includes/leftSidebar.jsp"/>--%>
    <%--</div>--%>
    <div class="col-md-12" id="view_tables"></div>
</div>
<div class="row">
    <a class="btn btn-primary" id="viewEvents"> View Event </a>
    <a class="btn btn-primary" id="viewLocations"> View Locations </a>
    <a class="btn btn-primary" id="viewPayments"> View Payments </a>
    <a class="btn btn-primary" id="viewTickets"> View Tickets </a>
    <a class="btn btn-primary" id="viewUsers"> View Users </a>
    <a class="btn btn-primary" id="viewVenues"> View Venues </a>
    <br/>
    <br/>
    <a class="btn btn-primary" id="addEvent"> Add Event </a>
    <a class="btn btn-primary" id="addLocation"> Add Location </a>
    <a class="btn btn-primary" id="addPayment"> Add Payment </a>
    <a class="btn btn-primary" id="addTicket"> Add Ticket </a>
    <a class="btn btn-primary" id="addUser"> Add User </a>
    <a class="btn btn-primary" id="addVenue"> Add Venue </a>
</div>
<div class="row">
    <div class="col-md-12" id="view_form"></div>
</div>
<script>
    $(function() {
        /*defaults*/
        loadFileContent("#view_tables", "${pageContext.request.contextPath}/jsp/tables/events.jsp");
        loadFileContent("#view_form", "${pageContext.request.contextPath}/jsp/forms/models/event.jsp");
        /*tables*/
        loadFileContentOnClick("#viewEvents", "#view_tables", "${pageContext.request.contextPath}/jsp/tables/events.jsp");
        loadFileContentOnClick("#viewLocations", "#view_tables", "${pageContext.request.contextPath}/jsp/tables/locations.jsp");
        loadFileContentOnClick("#viewPayments", "#view_tables", "${pageContext.request.contextPath}/jsp/tables/payments.jsp");
        loadFileContentOnClick("#viewTickets", "#view_tables", "${pageContext.request.contextPath}/jsp/tables/tickets.jsp");
        loadFileContentOnClick("#viewUsers", "#view_tables", "${pageContext.request.contextPath}/jsp/tables/users.jsp");
        loadFileContentOnClick("#viewVenues", "#view_tables", "${pageContext.request.contextPath}/jsp/tables/venues.jsp");
        /*forms*/
        loadFileContentOnClick("#addEvent", "#view_form", "${pageContext.request.contextPath}/jsp/forms/models/event.jsp");
        loadFileContentOnClick("#addLocation", "#view_form", "${pageContext.request.contextPath}/jsp/forms/models/location.jsp");
        loadFileContentOnClick("#addPayment", "#view_form", "${pageContext.request.contextPath}/jsp/forms/models/payment.jsp");
        loadFileContentOnClick("#addTicket", "#view_form", "${pageContext.request.contextPath}/jsp/forms/models/ticket.jsp");
        loadFileContentOnClick("#addUser", "#view_form", "${pageContext.request.contextPath}/jsp/forms/models/user.jsp");
        loadFileContentOnClick("#addVenue", "#view_form", "${pageContext.request.contextPath}/jsp/forms/models/venue.jsp");
    });
</script>

<%@ include file="/jsp/footer.jsp" %>

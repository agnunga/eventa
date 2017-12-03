<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>eventa</title>
    <link href="<c:url value="/assets/fastselect/dist/build.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/assets/fastselect/dist/fastselect.min.css"/>" rel="stylesheet">
    <%--<link rel="stylesheet" href="https://rawgit.com/dbrekalo/attire/master/dist/css/build.min.css"/>">--%>
    <link rel="stylesheet prefetch"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet prefetch"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet prefetch" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
    <link rel="stylesheet prefetch"  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <%--<link rel="stylesheet" href="/assets/datatables/dataTables.bootstrap.css">--%>
    <link href="<c:url value="/assets/datatables/jquery.dataTables.css"/>" rel="stylesheet">
    <link href="<c:url value="/assets/css/style.css"/>" rel="stylesheet"/>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <%--<script src="<c:url value="/assets/fastselect/dist/build.min.js" />"></script>--%>
    <%--<script src="https://rawgit.com/dbrekalo/attire/master/dist/js/build.min.js"></script>--%>
    <script src="<c:url value="/assets/fastselect/dist/fastselect.standalone.js" />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var baseUrl = "http://localhost:8080/eventa/";
    </script>
</head>
<body>
<div class="container">
    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="logo pull-left">
                    <a href="index.html"></a>
                    <a class="navbar-brand" href="../">eventa</a>
                </div>
                <div class="shop-menu pull-right">
                    <ul class="nav navbar-nav">
                        <li><a href="acount"><i class="fa fa-admin"></i> Account</a></li>
                        <li><a href="wishlist"><i class="fa fa-star"></i> Wishlist</a></li>
                        <li><a href="checkout"><i class="fa fa-crosshairs"></i> Checkout</a></li>
                        <li><a href="view_cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                        <%if (session.getAttribute("user_c") == null) {%>
                        <li><a href="login"><i class="fa fa-lock"></i> Login</a></li>
                        <%  }%>

                    </ul>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->
    <div class="row">
        <% if (request.getAttribute("message") != null) {%>
        <div class="row">
            <div class="col-sm-offset-2 col-sm-8 alert alert-warning" id="message-alert">
                <button type="button" class="close" data-dismiss="alert">x</button>
                <%=request.getAttribute("message")%>
            </div>
        </div>

        <script>
            $(function () {
                $("#message-alert").fadeTo(500, 500).slideUp(500, function () {
                    $("#message-alert").slideUp(500);
                });
            });
        </script>
        <%}%>
    </div>

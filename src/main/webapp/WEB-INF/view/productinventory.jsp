<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: bappy--%>
<%--Date: 1/26/17--%>
<%--Time: 2:38 PM--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>

<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>
<%--<meta name="description" content="">--%>
<%--<meta name="author" content="">--%>
<%--<link rel="icon" href="../../favicon.ico">--%>

<%--<title>Carousel Template for Bootstrap</title>--%>

<%--<!-- Bootstrap core CSS -->--%>
<%--&lt;%&ndash;<link href="css/bootstrap.min.css" rel="stylesheet">&ndash;%&gt;--%>

<%--<link href="<c:url value='resources/css/bootstrap.min.css' />" rel="stylesheet">--%>

<%--<link href="/resources/css/bootstrap.min.css" rel="stylesheet">--%>


<%--<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->--%>


<%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
<%--<!--[if lt IE 9]>--%>
<%--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>--%>
<%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
<%--<![endif]-->--%>


<%--</head>--%>
<%--<!-- NAVBAR--%>
<%--================================================== -->--%>
<%--<body>--%>
<%--<div class="navbar-wrapper">--%>
<%--<div class="container">--%>

<%--<nav class="navbar navbar-inverse navbar-static-top">--%>
<%--<div class="container">--%>
<%--<div class="navbar-header">--%>
<%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">--%>
<%--<span class="sr-only">Toggle navigation</span>--%>
<%--<span class="icon-bar"></span>--%>
<%--<span class="icon-bar"></span>--%>
<%--<span class="icon-bar"></span>--%>
<%--</button>--%>
<%--<a class="navbar-brand" href="#">Project name</a>--%>
<%--</div>--%>
<%--<div id="navbar" class="navbar-collapse collapse">--%>
<%--<ul class="nav navbar-nav">--%>


<%--<li class="active"><a href="<c:url value="/emusic"/>">Home</a></li>--%>
<%--<li><a href="<c:url value="/emusic/productlist" />">Product</a></li>--%>


<%--<li><a href="#contact">Contact</a></li>--%>
<%--<li class="dropdown">--%>
<%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
<%--<ul class="dropdown-menu">--%>
<%--<li><a href="#">Action</a></li>--%>
<%--<li><a href="#">Another action</a></li>--%>
<%--<li><a href="#">Something else here</a></li>--%>
<%--<li role="separator" class="divider"></li>--%>
<%--<li class="dropdown-header">Nav header</li>--%>
<%--<li><a href="#">Separated link</a></li>--%>
<%--<li><a href="#">One more separated link</a></li>--%>
<%--</ul>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</nav>--%>

<%--</div>--%>
<%--</div>--%>



<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/template/header.jsp"%>




<div class="container-wrapper">

    <div class="container">

        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Checkout all the awesome products available now</p>
        </div>

        <table class="table table-triped table-hover">

            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>View</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            </thead>


            <c:forEach items="${product}" var="product">

                <tr>
                    <td> <img src="<c:url value="/resources/images/${product.productId}.png" />" alt="image" style="width: 100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondiation}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<spring:url value="/emusic/productlist/viewproduct/${product.productId}" />"/>
                        <span class="glyphicon glyphicon-info-sign"></span></td>

                    <td><a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>" />
                        <span class="glyphicon glyphicon-remove-sign"></span></td>

                    <td><a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}"/>" />
                        <span class="glyphicon glyphicon-pencil"></span></td>

                </tr>

            </c:forEach>

        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct"/>" >click Here </a>



<%@include file="/WEB-INF/view/template/footer.jsp"%>
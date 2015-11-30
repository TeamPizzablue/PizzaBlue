<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fi.pizzablue.bean.Pizza"%>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
	<title>Tilausten tarkastelu</title>
	<link rel="stylesheet" type="text/css" href="css/adminstyles.css"/>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- Bootstrap Core CSS -->
 	<link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/grayscale.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
	<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
</head>

<body>

    <section id="hallinta" class="container content-section text-center">
    <div class="row">
<h1>Tilausten tarkastelu</h1>

<!-- juomat -->
<c:if test="${not empty param.lisatty}"><br><p class="pizzanluomisilmoitus">Uuden juoman luominen onnistui!</p></c:if>
<c:if test="${not empty param.poistettu}"><br><p class="pizzanpoistoilmoitus">Juoman poistaminen onnistui!</p></c:if>

<br>
<h2>Tilaukset</h2><br>
<div class="col-lg-10 sisaltopizza tilaustable text-uppercase table-responsive">
    <div class="ylinrivi col-lg-2"><strong>tilausnumero</strong></div>
    <div class="ylinrivi col-lg-2"><strong>aika</strong></div>
    <div class="ylinrivi col-lg-2"><strong>pizzojen määrä</strong></div>
    <div class="ylinrivi col-lg-2"><strong>juomien määrä</strong></div>
    <div class="ylinrivi col-lg-2"><strong>kotiinkuljetus/nouto</strong></div></div>
    <button class="lisatietojaBut btn btn-primary">Lisätietoja</button>
    <div class="lisatiedot col-lg-12">
    <p>Tilauksen tiedot <br/>
    id pizzanimi määrä<br/>
    pohjan tyyppi<br/>
    id juomannimi määrä<br/><br/>
    yhteishinta
    </p></div>
    
    <div class="col-lg-10 sisaltopizza tilaustable text-uppercase table-responsive">
    <div class="ylinrivi col-lg-2"><strong>tilausnumero</strong></div>
    <div class="ylinrivi col-lg-2"><strong>aika</strong></div>
    <div class="ylinrivi col-lg-2"><strong>pizzojen määrä</strong></div>
    <div class="ylinrivi col-lg-2"><strong>juomien määrä</strong></div>
    <div class="ylinrivi col-lg-2"><strong>kotiinkuljetus/nouto</strong></div></div>
    <button class="lisatietojaBut btn btn-primary">Lisätietoja</button>
    <div class="col-lg-12 lisatiedot">
    <p>Tilauksen tiedot <br/>
    id pizzanimi määrä<br/>
    pohjan tyyppi<br/>
    id juomannimi määrä<br/><br/>
    yhteishinta
    </p></div>
    </div>
    <br><br>
   </section>
</body>
<footer><br><br>
</footer>

<!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>
    
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('.lisatietojaBut').click(function() {
		// Use the current button which triggered the event
	  	$(this).siblings('.lisatiedot').slideToggle();	  
	});
});
	

</script>
    
</html>
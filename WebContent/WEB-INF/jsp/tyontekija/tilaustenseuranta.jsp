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

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Hallintapaneeli</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#">Tilaukset</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="kirjaudu_ulos">Kirjaudu ulos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

<section id="hallinta" class="container content-section text-center">
    <div class="row">
		<h1>Tilausten seuranta</h1>

		<!-- juomat -->
		<c:if test="${not empty param.lisatty}"><br><p class="pizzanluomisilmoitus">Uuden juoman luominen onnistui!</p></c:if>
		<c:if test="${not empty param.poistettu}"><br><p class="pizzanpoistoilmoitus">Juoman poistaminen onnistui!</p></c:if>

		<br>
		<h2>Tilaukset</h2><br>
		<c:forEach items="1,2,3" var="numero">
			<div class="col-lg-12 sisaltopizza tilaustable text-uppercase table-responsive">
    			<div class="ylinrivi col-lg-2"><strong>tilausnumero</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>aika</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>pizzojen määrä</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>juomien määrä</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>kotiinkuljetus/nouto</strong></div>
    			<div class="ylinrivi col-lg-2 lisatietojaBut"><button class="btn btn-default">Lisätietoja</button></div>
    			<div class="lisatiedot col-lg-12">
    			<div class="col-lg-8">
    				Tilauksen tiedot <c:out value="${numero}"/><br/>
   					id pizzanimi määrä<br/>
    				pohjan tyyppi<br/>
    				id juomannimi määrä<br/><br/>
    				
    			</div>
    			<div class="col-lg-4">
    				<p>yhteishinta</p>
    			</div>
    			<div class="col-lg-10"></div><div class="col-lg-2"><button class="btn btn-default">Tulosta tilaus</button></div></div>
   			</div>
		</c:forEach>
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
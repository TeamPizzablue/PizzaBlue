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

		<!-- tilan vaihto onnistunut -->
		<c:if test="${not empty param.vaihdettu}"><br><p style="color:lime;">Tilauksen tila vaihdettiin onnistuneesti!</p></c:if>

		<br>
		<h2>Tilaukset</h2><br>
		<div class="col-lg-12 sisaltopizza tilaustable text-uppercase table-responsive">
    			<div class="ylinrivi col-lg-2"><strong>tilausnumero</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>aika</strong></div>
    			<div class="ylinrivi col-lg-1"><strong>pizzojen määrä</strong></div>
    			<div class="ylinrivi col-lg-1"><strong>juomien määrä</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>toimitustapa</strong></div>
    			<div class="ylinrivi col-lg-2"><strong>tila</strong></div>
    			<div class="ylinrivi col-lg-2"></div>
    	</div>
		<c:forEach items="${tilaus}" var="tilaus">
			<div class="col-lg-12 sisaltopizza tilaustable text-uppercase table-responsive">
    			<div class="ylinrivi col-lg-2"><strong><c:out value="${tilaus.id}"/></strong></div>
    			<div class="ylinrivi col-lg-2"><strong><fmt:formatDate pattern="dd.MM.yy HH:mm" value="${tilaus.aikaleima}"/></strong></div>
    			<div class="ylinrivi col-lg-1"><strong><c:out value="${tilaus.pizzojenMaara}"/></strong></div>
    			<div class="ylinrivi col-lg-1"><strong><c:out value="${tilaus.juomienMaara}"/></strong></div>
    			<div class="ylinrivi col-lg-2"><strong><c:choose>
    			<c:when test="${tilaus.kotiinkuljetus == true}">Kotiinkuljetus</c:when>
    			<c:otherwise>Nouto</c:otherwise></c:choose></strong></div>
    			<c:choose>
    				<c:when test="${tilaus.tila == 1}"><div class="ylinrivi col-lg-2 saapunut"><strong>saapunut</strong></div></c:when>
    				<c:when test="${tilaus.tila == 2}"><div class="ylinrivi col-lg-2 valmistettu"><strong>valmistettu</strong></div></c:when>
    				<c:otherwise><div class="ylinrivi col-lg-2 maksettu"><strong>maksettu</strong></div></c:otherwise>
    			</c:choose>
    			<div class="ylinrivi col-lg-2 lisatietojaBut"><button class="btn btn-default">Lisätietoja</button></div>
    			<div class="lisatiedot col-lg-12">
    			<!-- pizzojen tiedot -->
    			<div class="col-lg-4" style="text-align:left;">
    				<c:forEach items="${tilaus.pizzat}" var="pizza">
   					<strong style="font-size:16px;"><c:out value="${pizza.numero}"/>. <c:out value="${pizza.nimi}"/></strong><strong><br>pohja: </strong>
    				<c:out value="${pizza.pohja}"/><strong><c:choose><c:when test="${pizza.oregano == false && pizza.valkosipuli == false}"> </c:when><c:otherwise>, mausteet: </c:otherwise></c:choose></strong>
    				<c:choose>
    				<c:when test="${pizza.oregano == true}">oregano</c:when>
    				<c:when test="${pizza.valkosipuli == true}">valkosipuli</c:when>
    				<c:otherwise></c:otherwise>
    			</c:choose><br>
    				</c:forEach>
    			</div>
    			<!-- juomien tiedot -->
    			<div class="col-lg-4" style="text-align:left;">
    			<c:forEach items="${tilaus.juomat}" var="juoma">
   					<strong style="font-size:16px;"><c:out value="${juoma.numero}"/>. <c:out value="${juoma.nimi}"/><br/></strong>
    				<br/>
    				</c:forEach>
    			</div>
    			<div class="col-lg-4">
    				<p>yhteishinta: <fmt:formatNumber value="${tilaus.hinta}" minFractionDigits="2"></fmt:formatNumber> €</p>
    			</div>
    			<div class="row">
    			<div class="col-lg-8"></div>
    			<div class="col-lg-4">
    			<c:choose>
    				<c:when test="${tilaus.tila == 1}">
    					<form action="muuta_valmistetuksi" method="post" style="display:inline-block;"><button class="btn btn-warning">Valmistettu</button><input type="hidden" name="tilausId" value="<c:out value="${tilaus.id}"/>"></form>
    				</c:when>
    				<c:when test="${tilaus.tila == 2}">
  						<form action="muuta_maksetuksi" method="post" style="display:inline-block;"><button class="btn btn-danger">Maksettu</button><input type="hidden" name="tilausId" value="<c:out value="${tilaus.id}"/>"></form>  					
    				</c:when>
    			</c:choose>
    			<form action="tulosta_tilaus" method="post" style="display:inline-block;"><br><button class="btn btn-default">Tulosta tilaus</button><input type="hidden" name="ordernr" value="<c:out value="${tilaus.id}"/>"></form><br><br>
    			</div>
    			</div>
    			</div>
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
	  	$(this).siblings('.lisatiedot').slideToggle();	  
	});
	
});
	

</script>
    
</html>
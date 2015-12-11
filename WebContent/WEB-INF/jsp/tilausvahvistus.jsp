<%@ page import="fi.pizzablue.bean.Pizza"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/grayscale.css" rel="stylesheet">

<!-- Team Blue CSS -->
<link href="css/teamblue_styles.css" rel="stylesheet">

<!-- Footable CSS -->
<link href="css/footable.bootstrap.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	  type="text/css">
<link
	  href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	  rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	  rel="stylesheet" type="text/css">

<title>Tilausvahvistus</title>
</head>

<body>
	<!-- Tilauksen lähetys -->
	<section id="tilauksenLähetys"
		class="container content-section text-center"
		style="padding-top: 50px !important;">
		<div class="row">
		<div class="col-lg-12">
			<h1>Tilausvahvistus</h1>
			<p>Vahvista syöttämäsi tiedot ennen tilauksen vahvistamista:
				<table class="sisalto text-uppercase footable">
				<thead>
				<tr class="tietorivi">
					<th data-breakpoints="xs sm">numero<span style="color:#42DCA3; font-size:25px;">*</span></th>
					<th>tuotenimi</th>
					<th>hinta</th>
					<th data-breakpoints="xs sm">lisämausteet</th>
					<th data-breakpoints="xs sm">pizzapohja</th>
				</tr>
				</thead>
					<!-- Tästä eteenpäin loopataan ostoskorin sisältö yllämainitussa järjestyksessä -->
					<c:forEach items="${tilaus.tilausrivit}" var="tilausrivi" varStatus="count">
					<c:if test="${tilausrivi.getClass().name == 'fi.pizzablue.bean.Pizzarivi'}">
					<tr class="tuoterivi">
						<td><c:out value="${tilausrivi.pizza.numero}"/></td>
						<td><c:out value="${tilausrivi.pizza.nimi}"/></td>
						<td><fmt:formatNumber value="${tilausrivi.pizza.hinta}" minFractionDigits="2"></fmt:formatNumber> €</td>
						<td>
							<c:if test="${tilausrivi.oregano == true}">
									Oregano
							</c:if>
							<c:if test="${tilausrivi.valkosipuli == true}">
									Valkosipuli
						</c:if>
						</td>
						<td><c:choose>
						<c:when test="${tilausrivi.pohja.nimi == 'tavallinen'}">
							Tavallinen
						</c:when>
						<c:when test="${tilausrivi.pohja.nimi == 'taysjyva'}">
							Täysjyvä
						</c:when>
						<c:otherwise>
							Gluteeniton
						</c:otherwise>
						</c:choose></td>
					</tr>
					</c:if>
					</c:forEach>
	
				<!-- Näyttää tilausrivin, yhteissumman sekä toimitustietojen sisällöt käyttäjälle -->
				<c:forEach items="${tilaus.tilausrivit}" var="tilausrivi" varStatus="count">
				<c:if test="${tilausrivi.getClass().name == 'fi.pizzablue.bean.Juomarivi'}">
					<tr class="tuoterivi">
						<td><c:out value="${tilausrivi.juoma.numero}"/></td>
						<td><c:out value="${tilausrivi.juoma.nimi}"/></td>
						<td><fmt:formatNumber value="${tilausrivi.juoma.hinta}" minFractionDigits="2"></fmt:formatNumber> €</td>
						<td></td><td></td>
					</tr>
				</c:if>
				</c:forEach>
				</table>
				<br/><br/>
				<h2 class="yhteissumma">Yhteissumma: <fmt:formatNumber value="${tilaus.hinta}" minFractionDigits="2"></fmt:formatNumber> &euro;</h2>
				<h5>sis. alv 14%</h5>
				<br/><br/>
				<!-- numeron selvennys, kyseessä ei ole rivinumero! - selitystä SAA MUUTTAA! -->
				<p><span style="color:#42DCA3; font-size:25px;">*</span>
				tarkoittaa tuotteen numeroa, jotta järjestelmämme tunnistaa tilaamasi tuotteet!</p>
				<h3>Toimitustiedot:</h3><br/>
				<p>
				<c:if test="${tilaus.etunimi != ''}"><c:out value="${tilaus.etunimi}"/></c:if>
				<c:if test="${tilaus.sukunimi != ''}"> <c:out value="${tilaus.sukunimi}"/></c:if><br/>
				<c:out value="${tilaus.katuosoite}"/><br/>
				<c:out value="${tilaus.postinro}"/> <c:out value="${tilaus.postitmp}"/><br/><br/>
				
				<c:out value="${tilaus.puhelinnumero}"/><br/>
				<c:if test="${tilaus.sahkoposti != ''}"><c:out value="${tilaus.sahkoposti}"/><br/></c:if><br/>
				
				<c:if test="${tilaus.lisatiedot != ''}">Lisätiedot: <c:out value="${tilaus.lisatiedot}"/><br/></c:if><br/>
				</p>
				
				<!-- Vahvista, peruuta ja palaa toimitustietoihin -napit -->
				<form action="laheta_tilaus" method="post">
				<div class="col-lg-6 col-md-6 col-xs-6" align="right">
					<button class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal" type="submit" value="Submit">Vahvista tilaus</button>
				</div>
				</form>
				<div class="col-lg-6 col-md-6 col-xs-6" align="left">
					<a href="tyhjenna_ostoskori" class="btn btn-danger btn-lg tyhjenna">Peruuta tilaus</a>
				</div>
			</div>
			</div>
			
				<%--<!-- Tilausvahvistuksen pop-up ikkuna -->
				 <div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<a class="pop-up"> <i class="fa"> <img style="height: 45px; margin-right:7px;" src="img/pienilogo_nega.png">
							</i>Pizza Blue
							</a>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
						<div class="modal-body">
							<h3 style="color: #42DCA3; margin-top: 5px;">Kiitos tilauksestanne!</h3>
							<p style="color: black;"> Tilauksenne on lähetetty ravintolalle. <br> <br>
								Tilausnumeronne on: <span class="tilausnumero"><c:out value="${tilaus.getId()}"></c:out></span> <br>
								<br> Otathan tilausnumeron talteen mahdollista
								ongelmatilannetta varten<span class="glyphicon glyphicon-heart"
									style="margin-left: 5px; color: #FF1975;" aria-hidden="true"></span>
							</p>
					</div>
						<!-- Etusivulle ja anna palautetta -napit -->
						<div class="modal-footer center-block" style="text-align: center;">
						<a href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage.jsp"
							class="btn btn-default btn-lg">Etusivulle</a> 
						<a href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage.jsp#yhteystiedot"
							class="btn btn-default btn-lg">Anna palautetta</a>
						</div>
					</div>

				</div>
			</div>
		</div>
		--%>
	</section>


	<!-- Footer -->
	<footer>
	<div class="container text-center">
		<p></p>
		</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="js/jquery.easing.min.js"></script>

	<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
	<script type="text/javascript"
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/grayscale.js"></script>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Footable JavaScript -->
		<script src="js/footable.js">
	</script>
	<script>
		$(function($) {
			$('.footable').footable({
				"breakpoints": {
					"xs": 400,
					"sm": 480,
					"md": 768,
					"lg": 1200
				}
			});
		});
		$(document).ready(function() {
			$("#tabs").tabs();
		});
	</script>
</body>

</html>
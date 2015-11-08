<%@ page import="fi.pizzablue.bean.Pizza"%>
<%@page import="java.text.DecimalFormat"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/grayscale.css" rel="stylesheet">

<!-- Team Blue CSS -->
<link href="css/teamblue_styles.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
	
	
<!-- Taulukon fontti -->	
<link href='https://fonts.googleapis.com/css?family=Muli' rel='stylesheet' type='text/css'>

<title>Tilaussivu</title>
</head>

<body>
<form action="siirry_toimitustietoihin" method="post" role="form" accept-charset="UTF-8">

	<!-- Ostoskori -->
	
	<section id="ostoskori" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1">
				<h2>Ostoskorin sisältö</h2>
				
				<table class="sisalto text-uppercase">
					<tr class="tietorivi">
						<td>numero</td>
						<td>tuotteen nimi</td>
						<td>hinta</td>
						<td>lisämausteet</td>
						<td>pizzapohja</td>
					</tr>
					
					<!-- Tästä eteenpäin loopataan ostoskorin sisältö yllämainitussa järjestyksessä. -->
					<c:forEach items="${tilaus.tilausrivit}" var="tilausrivi" varStatus="count">
					<c:if test="${tilausrivi.getClass().name == 'fi.pizzablue.bean.Pizzarivi'}">
					<tr class="tuoterivi">
							<td><c:out value="${tilausrivi.pizza.numero}"/></td>
						<td><c:out value="${tilausrivi.pizza.nimi}"/></td>
						<td><fmt:formatNumber value="${tilausrivi.pizza.hinta}" minFractionDigits="2"></fmt:formatNumber> €</td>
						<td style="text-align: left; padding: 15px 15px 15px 50px !important;">
								<input type="checkbox" name="mausteetV" value="<c:out value="${count.index}"/>">
								Valkosipuli <br> <input type="checkbox" name="mausteetO"
									value="<c:out value="${count.index}"/>"> Oregano
							</td>
						<td><select name="pizzapohja-<c:out value="${count.index}"/>"
							style="background-color: white; padding: 3px;" required
							class="btn-default btn pizzapohja">
								<option value="tavallinen">Tavallinen</option>
								<option value="taysjyva">Täysjyvä</option>
								<option value="gluteeniton">Gluteeniton</option>
						</select></td>
					</tr>
					
					</c:if>
				</c:forEach>
				
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
				
				<h3>
					<br><br><br> Yhteissumma: <fmt:formatNumber value="${tilaus.hinta}" minFractionDigits="2"></fmt:formatNumber> &euro;<br> <span></span>
				</h3>
				<%-- <p id="kuljetusmaksu" style="color:white"></p>--%>
								
			</div>
		</div>
	</section>

	<!-- Lähetä tilaus -->
	<section id="tilauksenLähetys"
		class="container content-section text-center"
		style="padding-top: 50px !important;">
		<div class="row">
			<div class="col-lg-12">
			
				<!-- Paluu etusivulle -->
				<a href="http://localhost:8080/pizzablue/frontpage#pitsalista" class="btn btn-default btn-lg" role="button">Palaa etusivulle</a>
			
				<!-- siirrytään eteenpäin tilausprosessissa -->
				<button class="btn btn-default btn-lg" type="submit" value="Submit">Jatka tilaamista  <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
			</div>
		</div>
	</section>
</form>

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

	<script>
		$(document).ready(function() {

			$("#tabs").tabs();

		});
	</script>


</body>

</html>
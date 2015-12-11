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


<!-- Taulukon fontti -->
<link href='https://fonts.googleapis.com/css?family=Muli'
	rel='stylesheet' type='text/css'>

<title>Tilaussivu</title>
</head>

<body>
	<form action="siirry_toimitustietoihin" method="post" role="form"
		accept-charset="UTF-8">

		<!-- Ostoskori -->

		<section id="ostoskori" class="container content-section text-center">
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1">
					<h2>Ostoskorin sisältö</h2>

					<table class="sisalto text-uppercase footable"
						data-show-toggle="true" data-expand-first="false" >
						<thead class="tietorivi">
							<tr>
								<th data-breakpoints="xs">tuotenumero</th>
								<th data-type="html" data-sort-use="text">tuotenimi</th>
								<th>hinta</th>
								<th data-breakpoints="xs" data-type="html" data-sort-use="text" >lisämausteet</th>
								<th data-breakpoints="xs sm" data-title="pizzapohja" data-type="html" data-sort-use="text">pizzapohja
									<span style="color: #42DCA3; font-size: 25px;">*</span>
								</th>
							</tr>
						</thead>
						<tbody>
							<!-- Tästä eteenpäin loopataan ostoskorin sisältö yllämainitussa järjestyksessä. -->
							<c:forEach items="${tilaus.tilausrivit}" var="tilausrivi"
								varStatus="count">
								<!-- jos tuote on pizzarivillä tulostetaan pizzan tietoja -->
								<c:if
									test="${tilausrivi.getClass().name == 'fi.pizzablue.bean.Pizzarivi'}">
									<tr class="tuoterivi">
										<td><c:out value="${tilausrivi.pizza.numero}" /></td>
										<!--  haetaan pizzan nimen eteen kuva pizzan numeron mukaan -->
										<td class="minikuvat" id="minikuvat"><img
											src="img/m<c:out value="${tilausrivi.pizza.numero}"/>.png"
											alt="kuva" align="left" class="pikkukuvat"> <c:out
												value="${tilausrivi.pizza.nimi}" /></td>
										<td><fmt:formatNumber value="${tilausrivi.pizza.hinta}"
												minFractionDigits="2"></fmt:formatNumber> €</td>
										<td class="mausteet"><input type="checkbox"
											name="mausteetV" value="<c:out value="${count.index}"/>">
											Valkosipuli <br /> <input type="checkbox" name="mausteetO"
											value="<c:out value="${count.index}"/>"> Oregano</td>
										<td>
											<!-- pizzapohjien valinnat saadaan mustalla värillä selkeämmäksi -->
											<select name="pizzapohja-<c:out value="${count.index}"/>"
											style="background-color: white; padding: 3px; color: black;"
											required class="btn-default btn pizzapohja">
												<option value="tavallinen">Tavallinen</option>
												<option value="taysjyva">Täysjyvä</option>
												<option value="gluteeniton">Gluteeniton</option>
										</select>
										</td>
									</tr>
								</c:if>
							</c:forEach>

							<c:forEach items="${tilaus.tilausrivit}" var="tilausrivi"
								varStatus="count">
								<!-- jos tuote on juomarivillä tulostetaan juoman tietoja -->
								<c:if
									test="${tilausrivi.getClass().name == 'fi.pizzablue.bean.Juomarivi'}">
									<tr class="tuoterivi">
										<td><c:out value="${tilausrivi.juoma.numero}" /></td>
										<!--  haetaan juoman nimen eteen kuva juoman numeron mukaan -->
										<td class="minikuvat" id="minikuvat"><img
											src="img/mj<c:out value="${tilausrivi.juoma.numero}"/>.png"
											alt="kuva" align="left" class="pikkukuvat"> <c:out
												value="${tilausrivi.juoma.nimi}" /></td>
										<td><fmt:formatNumber value="${tilausrivi.juoma.hinta}"
												minFractionDigits="2"></fmt:formatNumber> €</td>
										<td></td>
										<td></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
					<br> <br>
					<div class="col-lg-12">
						<p class="sisalto text-uppercase">
							Valitse tilauksen toimitusmuoto<span
								style="color: #42DCA3; font-size: 25px;">*</span>
						</p>
						<br>

						<!-- toimitustavan valinta -->
						<select name="toimitustapa"
							style="background-color: white; padding: 3px; color: black;"
							required class="btn-default btn pizzapohja">
							<option value="nouto">Nouto pizzeriasta</option>
							<option value="kotiinkuljetus">Kotiinkuljetus</option>
						</select><br> <br> <br>
					</div>
					<!-- toimitusehdot-->
					<div class="row">

						<div class="col-lg-6 tilausvaihtoehdot">
							<h3>Nouto</h3>
							<p>Noutotilauksen toimitusaika on 15-30 min.</p>
							<p>Noutotilausten vastaanotto päättyy puoli tuntia ennen
								sulkemista.</p>
						</div>
						<div class="col-lg-6 tilausvaihtoehdot">
							<h3>Kotiinkuljetus</h3>
							<p>Kotiinkuljetuksen toimitusaika on 30-60 min ja
								kuljetustilausten vastaanotto päättyy tuntia ennen sulkemista.</p>
							<p style="margin-bottom: 0;">
								Toimitusalueemme on 5km. Kotiinkuljetus maksaa <span
									class="kotiinkuljetushinta">2,99 €</span>.
							</p>
						</div>
					</div>
					<br> <br> <br>
					<!-- haetaan tilaus-oliosta tilauksen yhteissumma -->
					<h2 class="yhteissumma">
						Yhteissumma:
						<fmt:formatNumber value="${tilaus.hinta}" minFractionDigits="2"></fmt:formatNumber>
						&euro;
					</h2>
					<h5>sis. alv 14%</h5>
					<p class="small">
						<span class="tehostevari">*</span> Voit valita haluatko noutaa
						tilauksesi pizzeriastamme vai toimitammeko sen kotiovellesi.
					</p>
				</div>
			</div>
		</section>

		<!-- Lähetä tilaus -->
		<section id="tilauksenLähetys"
			class="container content-section text-center"
			style="padding-top: 20px !important;">
			<div class="row">
				<div class="col-lg-12">

					<!-- Paluu etusivulle -->
					<a
						href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage#pitsalista"
						class="btn btn-default btn-lg" role="button"><span
						class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
						Palaa etusivulle</a>

					<!-- siirrytään eteenpäin tilausprosessissa -->
					<button class="btn btn-default btn-lg" type="submit" value="Submit">
						Jatka tilaamista <span class="glyphicon glyphicon-arrow-right"
							aria-hidden="true"></span>
					</button>
				</div>
			</div>
		</section>
	</form>
	<form action="kotiinkuljetus_hinta" name="kotiinkuljetushinta"></form>
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
	</script>
</body>

</html>
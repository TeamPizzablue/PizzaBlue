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

<title>Tilaussivu</title>
</head>

<body>



	<!-- Tilaussivu -->
	<section id="tilaussivu" class="content-section text-center"
		style="padding: 0 !important;">
		<div class="download-section">
			<div class="container">
				<div class="col-lg-8 col-lg-offset-2">
					<h1>Tilaussivu</h1>
				</div>
			</div>
		</div>
	</section>


	<!-- Ostoskori -->
	<section id="ostoskori" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>Ostoskorin sisältö</h2>
				<table class="sisalto" style="margin: 0 auto; width: 100%;">
					<tr class="tietorivi">
						<td>id</td>
						<td>Tuotteen nimi</td>
						<td>Määrä</td>
						<td>Hinta &euro;</td>
						<td align="right">Lisämausteet</td>
						<td>Pizzapohja</td>
						<td></td>
					</tr>
					<!-- Tästä eteenpäin loopataan ostoskorin sisältö yllämainitussa järjestyksessä. -->
					<tr>
						<td>1</td>
						<td>Margarita</td>
						<td>1</td>
						<td>8,50</td>
						<td align="left"><form action="">
								<input type="checkbox" name="mausteet" value="valkosipuli"> Valkosipuli<br>
								<input type="checkbox" name="mausteet" value="oregano"> Oregano
							</form></td>
						<td><select name="Pizzapohja"
							style="background-color: white; padding: 3px;" required
							class="btn-default btn pizzapohja">
								<option value="">-Valitse-</option>
								<option value="Tavallinen">Tavallinen</option>
								<option value="Täysjyvä">Täysjyvä</option>
								<option value="Gluteeniton">Gluteeniton</option>
						</select></td>
						<td><button type="button" class="btn btn-danger">
								<span class=" glyphicon glyphicon-remove" aria-hidden="true"></span>
							</button></td>
					</tr>
				</table>

				<p>
					<br> Yhteissumma: 8,50 &euro;<br> <span></span>
				</p>
			</div>
		</div>
	</section>

	<!-- Toimitustiedot -->
	<section id="toimitustiedot"
		class="container content-section text-center">
		<div class="col-lg-12">

			<div class="row">
				<h2>Toimitustiedot</h2>

				<p style="font-size: 17px;">Valitse alhaalta haluamasi
					toimitustapa tilauksellesi. Jos haluat saada tilausvahvistuksen,
					muista mainita sähköpostiosoitteesi toimitustietoja täyttäessäsi.</p>

				<ul id="tabs" class="nav nav-tabs viiva-pois">
					<li class="active"><a href="#kotiinkuljetus"
						class="btn btn-default btn-lg butska" data-toggle="tab">Kotiinkuljetus</a>
					</li>
					<li><a href="#nouto" class="btn btn-default btn-lg butska"
						data-toggle="tab">Nouto</a></li>
				</ul>
				<br> <br>

				<!-- kotiinkuljetus -->
				<div id="kotiinkuljetus" class="tab-pane fade in active">
					<div class="col-lg-4 col-lg-offset-4">
						<form action="" method="post" role="form">
							<div class="form-group col-xs-6">
								<label for="Etunimi">Etunimi: </label><input
									class="form-control" type="text" name="etunimi"
									style="color: black" required>
							</div>
							<div class="form-group col-xs-6">
								<label for="Sukunimi">Sukunimi: </label><input
									class="form-control" type="text" name="sukunimi"
									style="color: black" required>
							</div>
							<div class="form-group col-xs-12">
								<label for="Katuosoite">Katuosoite: </label><input
									class="form-control" type="text" name="katuosoite"
									style="color: black" required>
							</div>
							<div class="form-group col-xs-6">
								<label for="Postinumero">Postinumero: </label><input
									class="form-control" type="text" name="postinumero"
									style="color: black" required>
							</div>
							<div class="form-group col-xs-6">
								<label for="Paikkakunta">Paikkakunta: </label><input
									class="form-control" type="text" name="sukunimi"
									style="color: black" required>
							</div>
							<div class="form-group col-xs-12">
								<label for="Puhelinnumero">Puhelinnumero: </label><input
									class="form-control" type="tel" name="puhelinnumero"
									style="color: black" required>
							</div>
							<div class="form-group col-xs-12">
								<label for="Sahkoposti">Sähköposti: </label><input
									class="form-control" type="email" name="sahkoposti"
									style="color: black">
							</div>
							<div class="form-group col-xs-12">
								<label for="Lisatietoja">Lisätietoja: </label>
								<textarea class="form-control" name="lisatietoja" rows="8"
									max-cols="40" style="color: black" required></textarea>
							</div>
						</form>
					</div>
				</div>

				<!-- nouto -->
				<div id="nouto" class="tab-pane fade">
					<div class="col-lg-4 col-lg-offset-4">
						<form action="" method="post" role="form">
							<div class="form-group col-xs-12">
								<label for="Puhelinnumero">Puhelinnumero: </label><input
									class="form-control" type="tel" name="puhelinnumero" required
									style="color: black" required>
							</div>
							<div class="form-group col-xs-12">
								<label for="Sahkoposti">Sähköposti: </label><input
									class="form-control" type="email" name="sahkoposti"
									style="color: black">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Lähetä tilaus -->
	<section id="tilauksenLähetys"
		class="container content-section text-center">
		<div class="row">
			<div class="col-lg-12">
				<!-- Tilauksen lähetys seka pop-up aukeaa, toiminnallisuus puuttuu vielä -->
				<button class="btn btn-default btn-lg" data-toggle="modal"
					data-target="#myModal" type="submit" value="Submit">Lähetä</button>
				<!-- Paluu kotisivulle, tarkoitus myös jopa tyhjentää koko sessio myöhemmin. -->
				<a
					href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage.jsp"
					class="btn btn-default btn-lg">Peruuta</a>
			</div>
			<!-- POP UP! -->
			<div id="myModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Modal Header</h4>
						</div>
						<div class="modal-body">
							<h3 style="color: #42DCA3; margin-top: 5px;">Kiitos
								tilauksestanne!</h3>
							<p style="color: black;">
								Tilauksenne on lähetetty ravintolalle. <br> <br>
								<!-- Tähän ohjataan tilausnumero -->
								Tilausnumeronne on: <span class="tilausnumero"></span> <br>
								<br> Otathan tilausnumeron talteen mahdollista
								ongelmatilannetta varten<span class="glyphicon glyphicon-heart"
									style="margin-left: 5px; color: #FF1975;" aria-hidden="true"></span>
							</p>
						</div>
						<div class="modal-footer center-block" style="text-align: center;">
							<a href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage.jsp"
								class="btn btn-default btn-lg" >Etusivulle</a> 
							<a href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage.jsp#yhteystiedot"
								class="btn btn-default btn-lg">Anna palautetta</a>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>


	<!-- Footer -->
	<footer>
		<div class="container text-center">
			<p>Copyright &copy; Ryhmä Blue 2015</p>
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
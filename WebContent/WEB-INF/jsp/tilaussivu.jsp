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
					<h2>Tilaussivu</h2>
				</div>
			</div>
		</div>
	</section>


	<!-- Ostoskori -->
	<section id="ostoskori" class="container content-section text-center">
		<div class="row">
			<div class="col-lg-12">
				<h2>Ostoskorin sisältö</h2>
				<table class="sisalto" style="margin: 0 auto;">
					<tr>
						<td>Tuotteen nimi</td>
						<td>Määrä</td>
						<td>Hinta &euro;</td>
						<td>Pizzapohja</td>
						<td></td>
					</tr>
					<tr>
						<td>Pizza</td>
						<td>1</td>
						<td>8,50</td>
						<td>
							<select name="Pizzapohja" style="background-color:white; padding:3px;" required class="btn-default btn pizzapohja">
								<option value="">-Valitse-</option>
								<option value="Tavallinen">Tavallinen</option>
								<option value="Täysjyvä">Täysjyvä</option>
								<option value="Gluteeniton">Gluteeniton</option>
							</select>
						</td>
						<td><button style="background: red;">X</button></td>
					</tr>


				</table>
			</div>
		</div>
	</section>

	<!-- Toimitustiedot -->
	<section id="toimitustiedot"
		class="container content-section text-center">
		<div class="row">
			<div class="col-lg-12">
				<h2>Toimitustiedot</h2>
			</div>
		</div>
	</section>

	<!-- Lähetä tilaus -->
	<section id="tilauksenLähetys"
		class="container content-section text-center">
		<div class="row">
			<div class="col-lg-12">
				<!-- Tilauksen lähetys, toiminnallisuus puuttu vielä -->
				<a href="pop-up" class="btn btn-default btn-lg">Lähetä tilaus</a>
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

</body>

</html>
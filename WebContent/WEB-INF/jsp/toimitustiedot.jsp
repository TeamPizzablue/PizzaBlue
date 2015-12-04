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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<title>Tilaustiedot</title>
</head>
<body>
	<!-- Toimitustiedot -->
	<section id="toimitustiedot"
		class="container content-section text-center" style="padding: 50px 0px 0px 0px !important;">
		<div class="col-lg-12">
				<%-- <h1>Valitse toimitustapa</h1>
				<p>Valitse
					alhaalta haluamasi toimitustapa tilauksellesi. Jos haluat saada
					tilausvahvistuksen, muista mainita sähköpostiosoitteesi
					toimitustietoja täyttäessäsi</p>
				<ul id="tabs" class="nav nav-tabs viiva-pois">
					<li class="active"><a href="#kotiinkuljetus"
						class="btn btn-default btn-lg butska" data-toggle="tab">Kotiinkuljetus</a>
					</li>
					 <li><a href="#nouto" class="btn btn-default btn-lg butska"
						data-toggle="tab">Nouto</a></li> 
				</ul>
				<br> <br>

				<!-- kotiinkuljetus -->
				
				<div id="my-tab-content" class="tab-content">
				<form action="siirry_toimitustietoihin" method="post" role="form">
					<div id="kotiinkuljetus" class="tab-pane fade in active">--%>
					<h1>Kotiinkuljetus</h1>
					
					<p> Muistathan ilmoittaa sähköpostiosoitteesi, mikäli haluat tilausvahvistuksen. </p>
					
					<form action="siirry_tilausvahvistukseen" method="post">
						<div class="col-lg-4 col-lg-offset-4">
								<div class="form-group col-xs-6">
									<label for="Etunimi">Etunimi: </label><input
										class="form-control" type="text" id="Etunimi" name="etunimi"
										style="color: black">
								</div>
								<div class="form-group col-xs-6">
									<label for="Sukunimi">Sukunimi: </label><input
										class="form-control" type="text" id="Sukunimi" name="sukunimi"
										style="color: black">
								</div>
								<div class="form-group col-xs-12"><!-- pakollinen kenttä, herjaa jos käyttäjä ei täytä -->
									<label for="Katuosoite">Katuosoite: * </label><input
										class="form-control" type="text" id="Katuosoite" name="katuosoite"
										style="color: black" oninvalid="setCustomValidity('Kerro osoite! ')"
 										   onchange="try{setCustomValidity('')}catch(e){}"  required>
								</div>
								<div class="form-group col-xs-6"> <!-- ei voi syöttää kirjaimia, vain numeroita 5 kpl -->
									<label for="Postinumero">Postinumero: * </label><input
										class="form-control" type="text" id="Postinumero" name="postinumero" 
										pattern="00002|00100|00102|00120|00130|00140|00150|00160|00170|00180|00190|
										00200|00210|00220|00230|00240|00250|00260|00270|00280|00290|
										00300|00310|00320|00330|00340|00350|00360|00370|00380|00390|
										00400|00410|00420|00430|00440|
										00500|00510|00520|00530|00540|00550|00560|00570|00580|00590|
										00600|00610|00620|00630|00640|00650|00660|00670|00680|00690|
										00700|00710|00720|00730|00740|00750|00760|00770|00780|00790|
										00800|00810|00820|00830|00840|00850|00860|00870|00880|00890|
										00900|00910|00920|00930|00940|00950|00960|00970|00980|00990|
										style="color:black"
										oninvalid="setCustomValidity('Toimitamme pizzoja ainoastaan Helsingin alueelle ')"
 										   onchange="try{setCustomValidity('')}catch(e){}" required> 
								</div>
								<div class="form-group col-xs-6"> <!-- ei voi syöttää numeroita, vain kirjaimia -->
									<label for="Paikkakunta">Paikkakunta: * </label><input
										class="form-control" type="text" id="Paikkakunta" name="paikkakunta" 
										pattern="[hH][eE][lL][sS][iI][nN][kK][iI]" style="color:black"
										oninvalid="setCustomValidity('Toimitamme pizzoja vain Helsingin alueelle ')"
  										  onchange="try{setCustomValidity('')}catch(e){}" required></div>
  										  
								<div class="form-group col-xs-12"> <!-- ei voi syöttää kirjaimia, vain numeroita 10 kpl -->
									<label for="Puhelinnumero">Puhelinnumero: *</label><input
										class="form-control" type="tel" id="Puhelinnumero" name="puhelinnumero" pattern="[0-9]{10}" placeholder="Anna puhelinnumero muodossa: 0401234567" style="color:black" oninvalid="setCustomValidity('Syötä vain numeroita! ')"
  										  onchange="try{setCustomValidity('')}catch(e){}" required></div>
										
								<div class="form-group col-xs-12"> <!-- sähköpostissa oltava @merkki ja piste -->
									<label for="Sahkoposti">Sähköposti: </label><input
										class="form-control" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" id="Sahkoposti" name="sahkoposti" style="color:black" oninvalid="setCustomValidity('Syötä sähköposti oikeassa muodossa (nimi@maili.com) ')"
   										 onchange="try{setCustomValidity('')}catch(e){}">
								</div> 
								<div class="form-group col-xs-12">
									<label for="Lisatietoja">Lisätietoja: </label>
									<textarea class="form-control" id="Lisatietoja" name="lisatietoja" rows="8" placeholder="Esim. ovikoodi" style="color: black"></textarea>
								</div>
						</div> <!-- Jatka tilaamista -painike / Palaa edelliselle sivulle -painike -->
						<div class="col-lg-8 col-lg-offset-2"><br>
						<a href="http://proto297.haaga-helia.fi:8080/pizzablue/ostoskorinsisalto" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>  Palaa edelliselle sivulle</a>
								<button class="btn btn-default btn-lg" type="submit" value="Submit">Jatka tilaamista  <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
								</div>
						</form>
					</div>
					
					
					<!-- nouto(lomake) ei vielä otettu käyttöön -->
					<%-- 
					<form action="siirry_toimitustietoihin" method="post" role="form">
					<div id="nouto" class="tab-pane fade">
						<div class="col-lg-4 col-lg-offset-4">
							
								<div class="form-group col-xs-12">
									<label for="Puhelinnumero">Puhelinnumero: *</label><input
										class="form-control" type="tel" name="puhelinnumero"
										style="color: black">
								</div>
								<div class="form-group col-xs-12">
									<label for="Sahkoposti">Sähköposti: </label><input
										class="form-control" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" name="sahkoposti" style="color:black" oninvalid="setCustomValidity('Syötä sähköposti oikeassa muodossa (nimi@maili.com) ')"
  										  onchange="try{setCustomValidity('')}catch(e){}">
								</div>
								<a href="http://localhost:8080/pizzablue/ostoskorinsisalto" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>  Edellinen sivu</a>
								<button class="btn btn-default btn-lg" type="submit" value="Submit">Seuraava sivu  <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
							
						</div>
					</div>
					
					</form> --%>
				
			
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

	<script>
		$(document).ready(function() {

			$("#tabs").tabs();

		});
	</script>




</body>

</html>
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

<!-- favicon kuva -->
<link rel="shortcut icon" type="image/png" href="img/favicon.png" />

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
	<section id="toimitustiedot" class="container content-section text-center" style="padding: 50px 0px 0px 0px !important;">
		<div class="col-lg-12">
			<h1>Nouto</h1>
					
			<p> Jos haluat sähköpostivahvistuksen tilauksestasi, kirjoita sähköpostiosoitteesi tälle lomakkeelle. </p>
					
			<form action="siirry_tilausvahvistukseen" method="post">
				<div class="row">
					<div class="col-lg-4 col-lg-offset-4">
						<div class="form-group col-xs-12">
							<label for="Puhelinnumero">Puhelinnumero: *</label>
							<input class="form-control" type="tel" id="Puhelinnumero" name="puhelinnumero" 
										pattern="[0-9]{10}" 
										style="color:black" 
										oninvalid="setCustomValidity('Syötä vain numeroita! ')"
    									onchange="try{setCustomValidity('')}catch(e){}" required>
    					</div>
										
						<div class="form-group col-xs-12">
							<label for="Sahkoposti">Sähköposti: </label>
							<input class="form-control" type="email" id="Sahkoposti" name="sahkoposti"
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" 
										style="color:black" 
										oninvalid="setCustomValidity('Syötä sähköposti oikeassa muodossa (nimi@maili.com) ')"
    									onchange="try{setCustomValidity('')}catch(e){}">
						</div>
						<div class="form-group col-xs-12">
							<label for="Lisatietoja">Lisätietoja: </label>
							<textarea class="form-control" id="Lisatietoja" name="lisatietoja" rows="8"
										placeholder="Esim. ovikoodi" style="color: black"></textarea>
						</div>
					</div>
				</div>
				<div class="col-lg-8 col-lg-offset-2"><br>
					<a href="http://proto297.haaga-helia.fi:8080/pizzablue/ostoskorinsisalto" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>  Palaa edelliselle sivulle</a>
					<button class="btn btn-default btn-lg" type="submit" value="Submit">Jatka tilaamista  <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span></button>
				</div>
			</form>
		</div>	
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

	<!-- Custom Theme JavaScript -->
	<script src="js/grayscale.js"></script>



</body>

</html>
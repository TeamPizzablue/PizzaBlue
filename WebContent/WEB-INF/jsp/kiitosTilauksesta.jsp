<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Pizza Blue:n arvoihin kuuluu kotimaisten, lähellä tuotettujen raaka-aineiden käyttö, sekä pyrkimys mahdollisimman pieneen hiilijalanjälkeen.">
	<meta name="robots" content="index, follow">
	<meta name="keywords" content="pizza, pizzeria, kotimainen, tilaus, kuljetus, ruoka, pitsalista, täytteet, gluteeniton, ruokavalio, arvot, helsinki, palaute, esittely, yhteystiedot, pasila">
	<title>Pizza Blue</title>
	<meta name="google-site-verification" content=""/>
    
    <link rel="shortcut icon" type="image/png" href="img/favicon.png"/>
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/grayscale.css" rel="stylesheet">
    
    <!-- Team Blue CSS -->
    <link href="css/teamblue_styles.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

	<link href="css/star-rating.min.css" media="all" rel="stylesheet" type="text/css" />

	<style>
	
	.container {
		background: url(../img/liitutaulu.jpg);
	}
		
	.kuva {
		max-width: 60%;
	}
	
	</style>

</head>
<body>
	<section class="container text-center">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
            	<br><br><br><br><br><br><br>
                <i class="fa"><img style="height: 45px; margin-right:7px;" src="img/pieni_logo.png">
							</i><br><br><h3>Pizza Blue</h3>
						<div class="modal-body">
							<h3 style="color: #42DCA3; margin-top: 5px;">Kiitos tilauksestanne!</h3>
							<p style="color: white;"> Tilauksenne on lähetetty ravintolalle. <br><br>
								<!-- Tilausnumero tähän -->
								Tilausnumeronne on: <span class="tilausnumero"><c:out value="${tilausid}"></c:out></span> <br>
								<br> Otathan tilausnumeron talteen mahdollista
								ongelmatilannetta varten<span class="glyphicon glyphicon-heart" style="margin-left: 5px; color: #FF1975;" aria-hidden="true"></span>
							</p>
						</div>
                <br><br><a href="http://localhost:8080/pizzablue/index.jsp" class="btn btn-default btn-lg">Takaisin pääsivulle</a>
                <a href="http://proto297.haaga-helia.fi:8080/pizzablue/frontpage.jsp#yhteystiedot" class="btn btn-default btn-lg">Anna palautetta</a> 
                <br><br><br><br><br><br>		
            </div> 
        </div>    
    </section>
</body>
</html>
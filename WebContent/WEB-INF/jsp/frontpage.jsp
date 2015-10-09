<%@ page import="fi.pizzablue.bean.Pizza"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% DecimalFormat dec = new DecimalFormat("0.00"); %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pizza Blue</title>
    
    
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
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa"><img src="img/pieni_logo.png" style="height:30px"></i><span class="light"> Pizza</span> Blue
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#esittely">Esittely</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#pitsalista">Pitsalista</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#yhteystiedot">Yhteystiedot</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                <div class="col-lg-1"></div>
                    <div class="col-lg-10">
               		<img src="img/iso_logo.png" class="img-responsive center-block col-xs-12" alt="Responsive image"> 
                 </div></div>
                 <div class="col-lg-1"></div>
                 <div class="row">
                 	<a href="#esittely" class="btn btn-circle page-scroll center-block">
                            <i class="fa fa-angle-double-down animated"></i>
                    </a>
                    </div>
                </div>
            </div>
    </header>

    <!-- About Section -->
    <section id="esittely" class="container content-section text-center">
    <img class="bonappetito img-responsive" align="left" src="img/Bonappetito.png" alt="bonappetito">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Esittely</h2>
                	<p>Vuonna 2012, kolme Pasilasta kotoisin olevaa ruokaa ja yhteisöllisyyttä arvostavaa ystävää päättivät lyödä intohimoiset päänsä yhteen ja perustaa Pizza Blue:n.<br><br>
Pizza Blue:n arvoihin kuuluu kotimaisten, lähellä tuotettujen raaka-aineiden käyttö, sekä pyrkimys mahdollisimman pieneen hiilijalanjälkeen. Haluamme tarjota asiakkaillemme myös mahdollisuuden 					tukea kotimaista työvoimaa hyödyntämällä myös muiden kotimaisten yrittäjien tarjoamia palveluita tuottaessamme aidosti kotimaisen makuelämyksen. 
<br><br>
Pizzeriassamme on laaja valikoima pizzoja, josta erilaisia ruokavaliota noudattavatkin voivat löytää jotain nautittavaa.
<br><br>
Pizzapohjamme on saanut myös tunnustusta useamman kerran kansainvälisessä <i>The Best Pizza In The Whole Wide World (TBPITWWW)</i> kilpailun parhaan pizzapohjan kategoriassa sijoittumalla kolmen 										parhaan joukkoon vuosina 2012-2014.
					</p>
					
            </div>
            <img class="slaissi img-responsive" align="right" src="img/Slaissi.png" alt="slaissi">
        	</div>
        	
        
    </section>

    <!-- Download Section --> 
    <section id="pitsalista" class="content-section text-center">
        <div class="download-section">
            <div class="container">
                <div class="col-lg-12">
                   <h2>Pitsalista</h2><br>
                   <div class="row">
                   <c:forEach items="${pizzat}" begin="0" end="3" var="pizza">
					  <div class="col-xs-12 col-lg-3">
					    <div class="thumbnail">
					      <img src="img/1.png" alt="">
					      <div class="caption">
					        <h3><c:out value="${pizza.numero}"/>. <c:out value="${pizza.nimi}"/></h3>
					        <p>Täytteet: <br>
					        <c:forEach items="${pizza.taytteet}" var="tayte">
					        	<c:out value="${tayte.nimi}"/>
					        </c:forEach>
					        </p>
					        <p class="tuotetiedot">Tuotetiedot: energia: <c:out value="${pizza.energia}"/>kcal proteiini: <c:out value="${pizza.proteiini}"/>g hiilihydraatti: <c:out value="${pizza.hiilihydraatti}"/>g rasva: <c:out value="${pizza.rasva}"/>g 
					        </p><p class="hinta"><fmt:formatNumber value="${pizza.hinta}" minFractionDigits="2"></fmt:formatNumber> €</p>
					        <p><a href="#" class="btn btn-default" role="button">Valitse</a></p>
					      </div>
					    </div>
					   </div>
					</c:forEach>
					</div>
					<div class="row">
                   <c:forEach items="${pizzat}" begin="4" end="7" var="pizza">
					  <div class="col-xs-12 col-lg-3">
					    <div class="thumbnail">
					      <img src="img/1.png" alt="">
					      <div class="caption">
					        <h3><c:out value="${pizza.numero}"/>. <c:out value="${pizza.nimi}"/></h3>
					        <p>Täytteet: <br><c:forEach items="${taytteet}" begin="4" end="7" var="tayte"><c:out value="${tayte.nimi}"/> </c:forEach></p>
					        <p class="tuotetiedot">Tuotetiedot: energia: <c:out value="${pizza.energia}"/>kcal proteiini: <c:out value="${pizza.proteiini}"/>g hiilihydraatti: <c:out value="${pizza.hiilihydraatti}"/>g rasva: <c:out value="${pizza.rasva}"/>g 
					        </p><p class="hinta"><fmt:formatNumber value="${pizza.hinta}" minFractionDigits="2"></fmt:formatNumber> €</p>
					        <p><a href="#" class="btn btn-default" role="button">Valitse</a></p>
					      </div>
					    </div>
					   </div>
					</c:forEach>
					</div>
						<div class="row">
                   <c:forEach items="${pizzat}" begin="8" end="11" var="pizza">
					  <div class="col-xs-12 col-lg-3">
					    <div class="thumbnail">
					      <img src="img/1.png" alt="">
					      <div class="caption">
					        <h3><c:out value="${pizza.numero}"/>. <c:out value="${pizza.nimi}"/></h3>
					        <p>Täytteet: <br><c:forEach items="${taytteet}" begin="8" end="11" var="tayte"><c:out value="${tayte.nimi}"/> </c:forEach></p>
					        <p class="tuotetiedot">Tuotetiedot: energia: <c:out value="${pizza.energia}"/>kcal proteiini: <c:out value="${pizza.proteiini}"/>g hiilihydraatti: <c:out value="${pizza.hiilihydraatti}"/>g rasva: <c:out value="${pizza.rasva}"/>g 
					        </p><p class="hinta"><fmt:formatNumber value="${pizza.hinta}" minFractionDigits="2"></fmt:formatNumber> €</p>
					        <p><a href="#" class="btn btn-default" role="button">Valitse</a></p>
					      </div>
					    </div>
					   </div>
					</c:forEach>
					</div>
				<img class="ateria img-responsive" align="left" src="img/Ateria.png" alt="ateria">
				</div>
			</div>
         </div>
    </section>

    <!-- Contact Section -->
    <section id="yhteystiedot" class="container content-section text-center">
    <br><h2>Yhteystiedot</h2>
    <div class="row">
            <div class="col-lg-6">
            <br><h3 class="yt-nimi">Pizza Blue</h3>
            <br><br>
            <p>Ratapihantie 13<br>
            00520 HELSINKI<br>
            Puh. 012 3456789<br>
            pizzablue@sahkoposti.fi</p>
            <p class="palvelemme">Palvelemme:</p>
            <p>Ma - to ja su 10 - 21<br>
            Pe - la 10 - 22
                </p>
                
                <!-- Tähtiarviointi -->
                 <div class="center-block" id="ratingbox"><input id="input-22" data-min="0" data-show-clear="false" data-max="5" data-step="1" value="0"></div>
                
                <ul class="list-inline banner-social-buttons">
                    <li>
                        <a href="https://facebook.com" class="btn btn-default btn-lg"><i class="fa fa-facebook fa-fw"></i> <span class="network-name">Facebook</span></a>
                    </li>
                    <li>
                        <a href="https://twitter.com" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                    </li>
                    <li>
                        <a href="https://plus.google.com/+Startbootstrap/posts" class="btn btn-default btn-lg"><i class="fa fa-google-plus fa-fw"></i> <span class="network-name">Google+</span></a>
                    </li>
                </ul>
               
          </div>
            
            <div class="col-lg-4">
                <br><h3>Palautelomake</h3>
                <form action="" method="post" role="form">
                <div class="form-group col-xs-6">
                <label for="nimi">Nimi: </label><input class="form-control" type="text" name="nimi" style="color:black"></div>
                <div class="form-group col-xs-6">
                <label for="puhelin">Puhelin: </label><input class="form-control" type="tel" name="puhelinumero" style="color:black"></div>
                <div class="form-group col-xs-12">
                <label for="sahkoposti">Sähköposti: </label><input class="form-control" type="email" name="sahkoposti" style="color:black"></div>
                <div class="form-group col-xs-12">
                <label for="viesti">Viesti: </label><textarea class="form-control" rows="8" max-cols="40" style="color:black"></textarea></div>
                <button class="btn btn-default" type="submit" >Lähetä</button>
                </form>
            </div>
         </div>
    </section>

    <!-- Map Section -->
    <div id="map"></div>

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
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDLzlVolWKgTA4-xE4KM7q28rG4BfP1agg&sensor=false"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>
    
    <!-- Tähtiarvointi -->
    <script src="js/star-rating.min.js" type="text/javascript"></script>
    
    <script>
    $(document).ready(function() {
    	$("#input-22").rating({
        	starCaptions: {1: "Kamala", 2: "Huono", 3: "Keskinkertainen", 4: "Hyvä", 5: "Erinomainen"},
        	starCaptionClasses: {1: "text-danger", 2: "text-warning", 3: "text-info", 4: "text-primary", 5: "text-success"},
    	});
    	$("#rating-stars").click(function(){
    		starCaptions: {""}
    	})
    });
    </script>
    
    
    
   <!-- Initialize your rating via javascript as follows -->


</body>

</html>

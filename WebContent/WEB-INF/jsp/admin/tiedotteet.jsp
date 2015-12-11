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
	<title>Tiedotteiden hallinta</title>
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
                        <a class="page-scroll" href="http://proto297.haaga-helia.fi:8080/pizzablue/admin">Tuotteet</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#">Tiedotteet</a>
                    </li>
                   <!-- <li>
                        <a class="page-scroll" href="">Aukioloajat</a>
                    </li>-->
                    <li>
                        <a class="page-scroll" href="kirjaudu_ulos">Kirjaudu ulos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <section id="tiedote" class="container content-section text-center">
        <div class="row">
        <h1>Tiedotteet</h1><br><br>
        	<div class="col-lg-8 col-lg-offset-2">
				<h2>Lisää uusi tiedote</h2>
				<c:if test="${not empty param.lisatty}"><br><p class="tiedotteenLisays">Uuden tiedotteen luominen onnistui!</p></c:if>
				<form action="uusi_tiedote" method="post">
					<div class="form-group col-xs-12">
						<label>Otsikko: </label><input class="form-control" type="text" name="otsikko" required></input>
					</div>
					<div class="form-group col-xs-12">
						<label>Tiedote: </label><textarea class="form-control" name="tiedote" rows="10" cols="50" placeholder="max. 500 merkkiä" style="color: black" required></textarea>
					</div>
					<button class="btn btn-default">Lisää tiedote</button>
				</form>
			</div>
		</div>
   </section>
   <section class="container content-section text-center">
     <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
        <h2>Poista tiedotteita</h2>
        <c:if test="${not empty param.poistettu}"><br><p class="tiedotteenPoisto">Tiedotteen poisto onnistui!</p></c:if>
        <c:forEach items="${tiedotteet}" var="tiedote" varStatus="count">
        	<blockquote>
        		<h4 style="color:#42DCA3;"><c:out value="${tiedote.otsikko}"/></h4>
        		<c:out value="${tiedote.sisalto}"/><br><br>
        		<form action="poista_tiedote" method="post">
        			<input type="hidden" name="id" value="<c:out value="${tiedote.id}"/>"><button class="btn btn-danger">Poista</button>
        		</form>
        	</blockquote>
        	<div style="color:white;"><h1>...</h1></div>
        </c:forEach>
        </div>
      </div>
   </section>
</body>
<footer>
	<br><br>
</footer>
<!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>
</html>
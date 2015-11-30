<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/registerlogin_styles.css"/>

<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/grayscale.css" rel="stylesheet">

<title>Sisäänkirjautuminen</title>
</head>
<body>

<section id="viesti" class="container text-center">
	<div class="row">
		<div class="col-lg-12">
			<div class="form-group col-md-4 col-md-offset-4">
				<c:if test="${not empty error }">
					<p class="Virhe">
						<c:out value="${error}" />
					</p>
				</c:if>
			</div>
		</div>
	</div>
</section>


<section id="login" class="container text-center">
	<div class="row">
		<div class="col-lg-12"><br/>
			<h3>Sisäänkirjautuminen</h3>
            <form action="kirjaudu" method="post">
            	<div class="form-group col-md-4 col-md-offset-4">
                	<label for="kayttajatunnus">Käyttäjätunnus: </label><input class="form-control" type="text" name="username" value="<c:out value="${prev_reg_username}"/>" style="color:black">
                </div>
                <div class="form-group col-md-4 col-md-offset-4">
                	<label for="salasana">Salasana: </label><input class="form-control" type="password" name="password" style="color:black">
                </div>
                <div class="form-group col-md-4 col-md-offset-4">
                	<button class="btn btn-default" type="submit" >Kirjaudu sisään</button>
                </div>
			</form>
		</div>
	</div>
</section>

<!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>
<!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
<!-- jQuery -->
    <script src="js/jquery.js"></script>
    
</body>
</html>
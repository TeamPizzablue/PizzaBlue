<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="styles/rekisteroityminen.css">
<title>Rekisteröityminen</title>
</head>
<body>


	<c:if test="${not empty param.onnistui }">
		<p class="Viesti">Rekisteröityminen onnistui!</p>
	</c:if>

	<c:if test="${not empty error }">
		<p class="Virhe">
			<c:out value="${error}" />
		</p>
	</c:if>

	<div id="register">

		<form action="rekisteroidy" method="post">
			<h1>Rekisteröityminen</h1>
			<table>
				<tr>
					<td>Käyttäjätunnus</td>
					<td><input type="text" name="username" value="<c:out value="${prev_reg_username}"/>"/></td>
				</tr>
				<tr>
					<td>Salasana</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Salasana uudestaan</td>
					<td><input type="password" name="password2" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button type="submit">Rekisteröidy</button></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>
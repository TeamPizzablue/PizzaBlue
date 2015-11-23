<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fi.pizzablue.bean.Pizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizzojen hallinta</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<h1>Lisää ja hallinnoi pizzoja</h1>

<p>Session aloitusaika: <fmt:formatDate value="${aloitus}" pattern="dd.MM.yyyy HH:mm:ss"/></p>

<c:if test="${not empty param.added}"><br><p class="pizzanluomisilmoitus">Uuden pizzan luominen onnistui!</p></c:if>
<c:if test="${not empty param.deleted}"><br><p class="pizzanpoistoilmoitus">Pizzan poistaminen onnistui!</p></c:if>

<br>
<table style="margin: 0 auto">
    <tr>
    <td class="ylinrivi id"><strong>id</strong></td>
    <td class="ylinrivi"><strong>nimi</strong></td>
    <td class="ylinrivi"><strong>hinta</strong></td>
    <td class="ylinrivi"><strong>toiminnot</strong></td>
    </tr>
    
    <c:forEach items="${pizzat}" var="pizza">
    <tr>
    <!-- nämä pitää olla c:outin sisällä, muuten käyttäjä pääsee syöttämään scriptejä syötekenttiin -->
    <td><c:out value="${pizza.id}"/></td>
    <td><c:out value="${pizza.nimi}"/></td>
    <td><fmt:formatNumber value="${pizza.hinta}"  minFractionDigits="2"/> &euro;</td>
    <td><button class="btn btn-warning nappula">Muokkaa</button>
    <form action="del" method="post"><input type="hidden" name="id" value="<c:out value="${pizza.id}"/>"><button class="btn btn-danger nappula">Poista</button></form></td>
    </tr>
    </c:forEach>
    	 <tr>
    	  <td></td>
    	  	<td><label for="nimi"><input type="text" name="nimi" form="addform"></label></td>
    	  	<td><label for="hinta"><input type="number" min="0" step="any" name="hinta" form="addform"></label></td>
    	  	<td><form action="add" method="post" id="addform"><button class="btn btn-success nappula" type="submit">Lisää</button></form></td>	
    	 </tr>
   </table>
    <br><br>
 <a href="img/yllapitotyokalu.png">Klikkaa tästä rautalankamalliin!</a>
</body>
</html>
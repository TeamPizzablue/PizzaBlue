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
<title>Pizzojen ja juomien hallinta</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<h1>Hallinnoi pizzoja ja juomia</h1>

<c:if test="${not empty param.added}"><br><p class="pizzanluomisilmoitus">Uuden pizzan luominen onnistui!</p></c:if>
<c:if test="${not empty param.deleted}"><br><p class="pizzanpoistoilmoitus">Pizzan poistaminen onnistui!</p></c:if>

<br>
<h2>Pizzat</h2><br>
<table style="margin: 0 auto">
    <tr>
    <td class="ylinrivi id"><strong>id</strong></td>
    <td class="ylinrivi"><strong>nimi</strong></td>
    <td class="ylinrivi"><strong>hinta</strong></td>
    <td class="ylinrivi"><strong>energia</strong></td>
    <td class="ylinrivi"><strong>proteiini</strong></td>
    <td class="ylinrivi"><strong>hiilihydraatti</strong></td>
    <td class="ylinrivi"><strong>rasva</strong></td>
    <td class="ylinrivi"><strong>toiminnot</strong></td>
    </tr>
    
    <c:forEach items="${pizzat}" var="pizza">
    <tr>
    <!-- nämä pitää olla c:outin sisällä, muuten käyttäjä pääsee syöttämään scriptejä syötekenttiin -->
    <td><c:out value="${pizza.id}"/></td>
    <td><c:out value="${pizza.nimi}"/></td>
    <td><fmt:formatNumber value="${pizza.hinta}"  minFractionDigits="2"/> &euro;</td>
    <td><c:out value="${pizza.energia}"/></td>
    <td><fmt:formatNumber value="${pizza.proteiini}"  minFractionDigits="2"/></td>
    <td><fmt:formatNumber value="${pizza.hiilihydraatti}"  minFractionDigits="2"/></td>
    <td><fmt:formatNumber value="${pizza.rasva}"  minFractionDigits="2"/></td>
    <td>
    <form action="del" method="post"><input type="hidden" name="id" value="<c:out value="${pizza.id}"/>"><button class="btn btn-danger nappula">Poista</button></form></td>
    </tr>
    </c:forEach>
    	 <tr>
    	  <td></td>
    	  	<td><label for="nimi"><input type="text" name="nimi" form="addform"></label></td>
    	  	<td><label for="hinta"><input type="number" min="0" step="any" name="hinta" form="addform"></label></td>
    	  	<td><label for="energia"><input type="number" min="0" step="any" name="energia" form="addform"></label></td>
    	  	<td><label for="proteiini"><input type="number" min="0" step="any" name="proteiini" form="addform"></label></td>
    	  	<td><label for="hiilihydraatti"><input type="number" min="0" step="any" name="hiilihydraatti" form="addform"></label></td>
    	  	<td><label for="rasva"><input type="number" min="0" step="any" name="rasva" form="addform"></label></td>
    	  	<td><form action="add" method="post" id="addform"><button class="btn btn-success nappula" type="submit">Lisää</button></form></td>	
    	 </tr>
   </table>
    <br><br>
    <h2>Juomat</h2><br>
    <table style="margin: 0 auto">
    <tr>
    <td class="ylinrivi id"><strong>id</strong></td>
    <td class="ylinrivi"><strong>nimi</strong></td>
    <td class="ylinrivi"><strong>maara</strong></td>
    <td class="ylinrivi"><strong>hinta</strong></td>
    <td class="ylinrivi"><strong>energia</strong></td>
    <td class="ylinrivi"><strong>proteiini</strong></td>
    <td class="ylinrivi"><strong>hiilihydraatti</strong></td>
    <td class="ylinrivi"><strong>rasva</strong></td>
    <td class="ylinrivi"><strong>toiminnot</strong></td>
    </tr>
    
    <c:forEach items="${juomat}" var="juoma">
    <tr>
    <!-- nämä pitää olla c:outin sisällä, muuten käyttäjä pääsee syöttämään scriptejä syötekenttiin -->
    <td><c:out value="${juoma.id}"/></td>
    <td><c:out value="${juoma.nimi}"/></td>
     <td><c:out value="${juoma.maara}"/></td>
    <td><fmt:formatNumber value="${juoma.hinta}"  minFractionDigits="2"/> &euro;</td>
    <td><c:out value="${juoma.energia}"/></td>
    <td><fmt:formatNumber value="${juoma.proteiini}"  minFractionDigits="2"/></td>
    <td><fmt:formatNumber value="${juoma.hiilihydraatti}"  minFractionDigits="2"/></td>
    <td><fmt:formatNumber value="${juoma.rasva}"  minFractionDigits="2"/></td>
    <td>
    <form action="del" method="post"><input type="hidden" name="id" value="<c:out value="${juoma.id}"/>"><button class="btn btn-danger nappula">Poista</button></form></td>
    </tr>
    </c:forEach>
    	 <tr>
    	  <td></td>
    	  	<td><label for="nimi"><input type="text" name="nimi" form="addform"></label></td>
    	  	<td><label for="maara"><input type="number" min="0" step="any" name="maara" form="addform"></label></td>
    	  	<td><label for="hinta"><input type="number" min="0" step="any" name="hinta" form="addform"></label></td>
    	  	<td><label for="energia"><input type="number" min="0" step="any" name="energia" form="addform"></label></td>
    	  	<td><label for="proteiini"><input type="number" min="0" step="any" name="proteiini" form="addform"></label></td>
    	  	<td><label for="hiilihydraatti"><input type="number" min="0" step="any" name="hiilihydraatti" form="addform"></label></td>
    	  	<td><label for="rasva"><input type="number" min="0" step="any" name="rasva" form="addform"></label></td>
    	  	<td><form action="lisaajuoma" method="post" id="addform"><button class="btn btn-success nappula" type="submit">Lisää</button></form></td>	
    	 </tr>
   </table>
</body>
</html>
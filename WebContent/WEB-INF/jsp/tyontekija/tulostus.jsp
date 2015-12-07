<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tulosta tilaus</title>
</head>
<body style="text-align:center;">
<h1>Tilausnumero: <c:out value="${tilaus.id}"/></h1>
<p>Aikaleima: <c:out value="${tilaus.aikaleima}"/></p>
<p>Toimitustapa: <c:out value="${tilaus.kotiinkuljetus}"/></p>
<p>Tuotteet: </p>
</body>
</html>
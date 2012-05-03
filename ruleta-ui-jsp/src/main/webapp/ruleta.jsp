<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >

<%@ page isELIgnored ="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="styles.css" />
	<title>Ruleta-ui-jsp</title>
</head>
<body>

<p>Version 5</p>
<%if (request.getAttribute("error") != null) {
	// abro%><p>${error}</p><%
	}%>


	<p>Bienvenido:<%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>${sessionScope.jugador.nombre}<%
	}%></p>
	<br/><br/>
	
	<p>Fichas:<%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>${sessionScope.jugador.fichas}<%
	}%>"</p>
	<br/><br/>
	




</body>
</html>
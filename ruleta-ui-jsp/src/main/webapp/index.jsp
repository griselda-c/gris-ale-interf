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

<form method="post" action="adjuntarjugador" id="datos">
	<p>Ingrese su nombre:<br/>
	<input type="text" name="nombreJugador" value="<%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>${sessionScope.jugador.nombre}<%
	}
	else{
	// abro%><%
	}// cierro %>"/>
	<br/><br/>
	
	Ingrese su dinero:<br/>
	<input type="text" name="dineroJugador" value="<%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>${sessionScope.jugador.dinero}<%
	}
	else{
	// abro%><%
	}// cierro %>"/>
	<br/><br/>
	</p>
	
	<input type="submit" value="Iniciar juego" />	
</form>


</body>
</html>
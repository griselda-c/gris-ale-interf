
<%@ page isELIgnored ="false" %>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ruleta</title>
</head>

<body>
<div id="false-body">

<div id="header">


<div id="logo">
<IMG src="images/logo.png" alt="Ruleta" title="Ruleta" style="background: none; width: 600px; height: 133px; border: 0px; margin-top: 30px; padding: 0px;">
</div > <!-- cierra logo -->


</div > <!-- cierra header -->

<div id="session">

  <div id="session-left">
  </div > <!-- cierra session-left -->
  
  <div id="session-right">
  </div > <!-- cierra session-right -->
  <div id="session-center2">
  
  
  <%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>
	
	<p class="session2"><a href="../login/login-out.php" title="Abandonar la sesion actual"><b>Cerrar sesi&oacute;n</b></a></p>  
    </div > <!-- session-center2 -->
  
    <div id="session-center1">
    <p class="session1">Sesion iniciada por <span style="color: #ff4;">${sessionScope.jugador.nombre}</span></p>
	
	
	
	
	<%
	}
	else{
	// abro%>
	
	<p class="session2-of"><a href="#" title="No hay sesion iniciada"><b>Cerrar sesi&oacute;n</b></a></p>
    </div > <!-- session-center2 -->
	
    <div id="session-center1">
    <p class="session1">No se ha iniciado sesi&oacute;n a&uacute;n</p>
	
	<%
	}// cierro %>
  
 
  </div > <!-- session-center1 -->

  
</div > <!-- cierra session -->




<div id="real-body">

  <div id="body-left">
  
  
  <div id="menu-left">
  
  
   
   <div id="muestraapuestas">
   <p>Fichas disponibles: ${sessionScope.jugador.fichas}</p>
   
   
   <%
	if (request.getSession().getAttribute("mostrarapuesta") != null) {
	// abro%>
	<p>Apuesta a mostrar: ${sessionScope.mostrarapuesta}</p>   
	<%}
	else{
	// abro%>
	<p>contenido si no</p>	
    <%}%>
    <form action="apostar" method="post" id="form_apuesta" name="form_apuesta">		
		<p>Ingrese la cantidad de fichas que desea apostar:<br>
		<input id="fichasapostar" name="fichasapostar" type="text" size="12" style="font-family: sans-serif; font-size: 16px; margin-top: 10px; border: 0px;">
		</p>
		<input type="hidden" name="apuesta" value="${sessionScope.mostrarapuesta}">
		<input type="submit" value="Apostar" >
    </form>	
   
   
   </div > <!-- cierra muestraapuestas -->
   
   
  </div > <!-- cierra menu-left -->

  
    <div id="menu-left-boot">  
    </div > <!-- cierra menu-left-boot -->

  </div > <!-- cierra body-left -->
  

	
	
  <div id="body-right">
		
  </div > <!-- cierra body-right -->
  
  
  <div id="body-center">
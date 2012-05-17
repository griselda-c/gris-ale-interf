
<%@ page isELIgnored ="false" %>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ruleta</title>



</head>

<body onload="javascript:actualizarTablero();validarApostar();">
<div id="false-body">

<div id="header">


<div id="logo">
<IMG src="images/logo.png" alt="Ruleta" title="Ruleta" style="background: none; width: 400px; height: 160px; border: 0px; margin-top: 30px; padding: 0px;">
</div > <!-- cierra logo -->


</div > <!-- cierra header -->

<div id="session">

  <div id="session-left">
  </div > <!-- cierra session-left -->
  
  <div id="session-right">
  </div > <!-- cierra session-right -->
  <div id="session-center2">
    
    <%if (request.getSession().getAttribute("jugador") != null) {%>
	
	<p class="session2"><a href="loginout" title="Abandonar la sesion actual"><b>Cerrar sesi&oacute;n</b></a></p>  
    </div > <!-- session-center2 -->
  
    <div id="session-center1">
    <p class="session1">Sesion iniciada por <span style="color: #ff4;">${sessionScope.jugador.nombre}</span></p>
		
	<%}else{%>
	
	<p class="session2-of"><a href="#" title="No hay sesion iniciada"><b>Cerrar sesi&oacute;n</b></a></p>
    </div > <!-- session-center2 -->
	
    <div id="session-center1">
    <p class="session1">No se ha iniciado sesi&oacute;n a&uacute;n</p>
	
	<%}%>  
 
  </div > <!-- session-center1 -->
  
</div > <!-- cierra session -->


<div id="real-body">

  <div id="body-left">  
  
  <div id="menu-left">   
   
   <div id="muestraapuestas">
   
    <%if (request.getSession().getAttribute("jugador") != null) {%>
    
    
    <p id="fichasVista">Fichas disponibles: ${sessionScope.jugador.fichas}</p><br/>	
    
    <div id="jugada">
    <p>Seleccione una jugada del paño para realizar la apuesta</p>
    </div > <!-- cierra jugada -->  
    <br/>
    
		
		<p>Ingrese la cantidad de fichas que desea apostar:<br>
		<input id="apuestaFichas"  onkeyup="javascript:validarApostar();" name="apuestaFichas" type="text" size="12" style="font-family: sans-serif; font-size: 16px; margin-top: 10px; border: 0px;">
		
		<input type="button" id="apostar" value="Apostar" onclick="javascript:enviarApuesta();" >
		</p>
		<input type="hidden" id="fichasHidden" value="${sessionScope.jugador.fichas}">
		<input type="hidden" id="apuestaTipo" value="">
		<input type="hidden" id="opcionNombre" value="">
		<br/>
        <input type="button" id= "girarRuleta" value="Girar Ruleta" onclick="javascript:girarRuleta();"  />
	    <br/>
	    <br/>
	    <p id= "numeroGanadorVista"> </p>
	    
	    <br/>
	    
	    <div id="apuestasColeccion"></div>
	    
	<%}else{%>
	<p>Inicie sesión para realizar apuestas</p>
		
    <%}%>
      
    </div > <!-- cierra muestraapuestas -->   
   
  </div > <!-- cierra menu-left -->
  
    <div id="menu-left-boot">  
    </div > <!-- cierra menu-left-boot -->

  </div > <!-- cierra body-left -->
	
  <div id="body-right">
  
  
  <div id="registrar">
  </div> <!-- cierra registrar -->  
		
  </div > <!-- cierra body-right -->  
  
  <div id="body-center">
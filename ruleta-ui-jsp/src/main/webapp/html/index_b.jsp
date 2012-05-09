
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
    <ul class="menu-left">
      <!--  <li <?php if($actual == "upload")	    {echo "class=\"current-left\"><a href=\"#\"";}	else{echo "><a href=\"../site/upload.php\""; }    ?>	 title="Comparta sus archivos"><b>Almacenar</b></a></li>
      <li <?php if($actual == "download")   {echo "class=\"current-left\"><a href=\"#\"";}	else{echo "><a href=\"../site/download.php\"";}   ?>	 title="Descargue archivos"><b>Descargar</b></a></li>
      <li <?php if($actual == "self-files") {echo "class=\"current-left\"><a href=\"#\"";}	else{echo "><a href=\"../site/self-files.php\"";} ?>	 title="Administre sus archivos"><b>Mis archivos</b></a></li>
      <li <?php if($actual == "count")	    {echo "class=\"current-left\"><a href=\"#\"";}	else{echo "><a href=\"../site/count.php\"";}      ?>	 title="Mi cuenta"><b>Mi cuenta</b></a></li>
      <li <?php if($actual == "exit")         {echo "class=\"current-left\"><a href=\"#\"";}	else{echo "><a href=\"../site/exit.php\"";}   ?>	 title="Link # 2"><b>Exit</b></a></li>
      <li <?php if($actual == "L3")         {echo "class=\"current-left\"><a href=\"#\"";}	else{echo "><a href=\"#\"";}                                 ?>	 title="Link # 3"><b>Link # 3</b></a></li>
    --></ul>  <!-- cierra menu-left -->
  </div > <!-- cierra menu-left -->

  
    <div id="menu-left-boot">  
    </div > <!-- cierra menu-left-boot -->

  </div > <!-- cierra body-left -->
  

	
	
  <div id="body-right">
		
  </div > <!-- cierra body-right -->
  
  
  <div id="body-center">
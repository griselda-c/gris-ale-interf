
<jsp:include page="html/index_a.jsp" />

<%@ page isELIgnored ="false" %>

<LINK rel="stylesheet" href="css/style-index.css" type="text/css" media="all">

<jsp:include page="html/index_b.jsp" />

<script type="text/javascript">
  function actualizarTablero(){	  
    <%if (request.getSession().getAttribute("jugador") != null) {%>		
    location.href="jugar.jsp";		
    <%}else{%>
    //alert("esta todo bien gil");
    //comportamiento cuando inicia index sin jugador
	<%}%>  
  }
  
  </script>
<div id="log">
  <div id="log-top">
  
  <p class="log-text">Ingrese sus datos<p/>
  <p class="log-text">para iniciar sesion.<p/>
  
  </div><!-- cierra log-top -->
  <div id="log-bot">

 <form action="adjuntarjugador" method="post" id="form_log" name="form_log">
		<p>Ingrese su nombre:<br>
		<input id="nombreJugador" name="nombreJugador" type="text" size="25" style="font-family: sans-serif; font-size: 16px; margin-top: 10px; border: 0px;" 
           onKeyPress="javascript:submitEnterLogin(this, event)">
		</p>
		<p>Ingrese la cantidad de dinero:<br>
		<input id="dineroJugador" name="dineroJugador" type="text" size="25" style="font-family: sans-serif; font-size: 16px; margin-top: 10px; border: 0px;"
           onKeyPress="javascript:submitEnterLogin(this, event)">
		</p>
		<p class="button">
		<a href="javascript:validarYEnviar();">Enviar</a>
		<a href="javascript:document.form_log.reset()">Borrar</a>
		</p>
    </form>	
 
  </div><!-- cierra log-bot -->
</div><!-- cierra log -->

<jsp:include page="html/index_c.jsp" />

<jsp:include page="html/index_a.jsp" />

<%@ page isELIgnored ="false" %>

<LINK rel="stylesheet" href="css/style-index.css" type="text/css" media="all">

<jsp:include page="html/index_b.jsp" />

<SCRIPT TYPE="text/javascript">

function submitenter(myfield,e)
{
var keycode;
if (window.event) keycode = window.event.keyCode;
else if (e) keycode = e.which;
else return true;

if (keycode == 13)
   {
   myfield.form.submit();
   return false;
   }
else
   return true;
}

</SCRIPT>

<div id="log">
  <div id="log-top">
  
  <p class="log-text">Ingrese sus datos<p/>
  <p class="log-text">para iniciar sesion.<p/>
  
  </div><!-- cierra log-top -->
  <div id="log-bot">

 <form action="adjuntarjugador" method="post" id="form_log" name="form_log">
		<p>Nombre de usuario:<br>
		<input id="nombreJugador" name="nombreJugador" type="text" size="25" style="font-family: sans-serif; font-size: 16px; margin-top: 10px; border: 0px;" 
           onKeyPress="javascript:submitenter(this,event)">
		</p>
		<p>Dinero:<br>
		<input id="dineroJugador" name="dineroJugador" type="text" size="25" style="font-family: sans-serif; font-size: 16px; margin-top: 10px; border: 0px;"
           onKeyPress="javascript:submitenter(this,event)">
		</p>
		<p class="button">
		<a href="javascript:document.form_log.submit()">Enviar</a>
		<a href="javascript:document.form_log.reset()">Borrar</a>
		</p>
    </form>	
 
  </div><!-- cierra log-bot -->
</div><!-- cierra log -->

<jsp:include page="html/index_c.jsp" />
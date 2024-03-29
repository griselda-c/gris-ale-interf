var enviando = false;
var apustasrealizadas = new Array();
var apuestasServer;


function ApuestaWeb(tipoP, jugadaP, fichasP){
	  this.tipo = tipoP;
	  this.jugada = jugadaP;
	  this.fichas = fichasP;
	  this.procesada = false;
	  this.mostrar = function() {
			 return this.tipo +  this.jugada + this.fichas;
		  };
	  this.apostar = function() {
		 document.getElementById(this.tipo + '-' + this.jugada).style.backgroundImage = "url('images/chip.png')";
	  };
	  this.desapostar = function() {
		  document.getElementById(this.tipo + '-' + this.jugada).style.backgroundImage = "none";
	  };
	  this.procesar = function() {
		  this.procesada = true;
	  };
	  this.equals = function(anotherAWeb) {
		  return (anotherAWeb.tipo == this.tipo) && (anotherAWeb.jugada == this.jugada) && (anotherAWeb.fichas == this.fichas);
	  };
	}

/***
 * estructura del response de postar
 * error:boolean true  -> descripcion-del-error:string
 *               false -> dineroJugador
 *                        [[apuestaTipo, opcionValor, apuestaFichas], [apuestaTipo, opcionValor, apuestaFichas]]
 * 
 */

function enviarApuesta(){
	if(!enviando){	
	  bloquearEnvios();
	  var tipo = document.getElementById('apuestaTipo').value;
	  var jugadaNombre = document.getElementById('opcionNombre').value;
	  var fichas = document.getElementById('apuestaFichas').value;
	  var ajax;
	  ajax = new ajaxFunction();
	  var catchError = setTimeout(function(){ajax.abort();mostrarError("Error en la coneccion, intentelo nuevamente");desbloquearEnvios();}, 10000);
      ajax.onreadystatechange = function(){
	    if(ajax.readyState == 4){	
          if(ajax.status == 200){
            clearTimeout(catchError);
        	registrar(ajax.responseText);
        	var respuestaServer = eval(ajax.responseText);
        	if(respuestaServer[0] == 1){//hubo un error
        		mostrarError(respuestaServer[1]);
        	}
        	else if(respuestaServer[0] == 2){
        		loggear();
        	}else{
        		actualizarEstado(respuestaServer);
        	}
            desbloquearEnvios();
        	validarApostar();
          }
        }
	  }
      var envio = "apostar?apuesta=" + tipo + "&jugada=" + jugadaNombre + "&fichasapostar=" + fichas;
      //alert(envio);
	  ajax.open("GET", envio, true);
	  ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  ajax.send(null);
	}
}


function loggear(){
	alert("debe iniciar session para poder apostar");
	location.href="index.jsp";
	header("location: index.jsp");
}

function actualizarEstado(arrayEstado){
	document.getElementById('fichasHidden').value = arrayEstado[1];
	document.getElementById('fichasVista').innerHTML = "Fichas disponibles: " + arrayEstado[1];	
		
	apuestasServer = new Array();

	for(var i = 0; i<arrayEstado[2].length; i++){
		apuestasServer.push(new ApuestaWeb(arrayEstado[2][i][0], arrayEstado[2][i][1], arrayEstado[2][i][3]));
	}
	
	for(var i = 0; i<apustasrealizadas.length; i++){
		apustasrealizadas[i].desapostar();
		//registrar("des - " + apustasrealizadas[i].mostrar());				
	}
	
	for(var i = 0; i<apuestasServer.length; i++){
		apuestasServer[i].apostar();
		//registrar("apostada - " + apuestasServer[i].mostrar());
	}
	apustasrealizadas = apuestasServer;
	mostrarColeccionApuestas();
	}

function mostrarError(descripcionError){
	alert(descripcionError);
}

function bloquearEnvios(){
	enviando = true;
	document.getElementById('apostar').disabled = true;
	document.getElementById('girarRuleta').disabled = true;
}

function desbloquearEnvios(){
	enviando = false;
	document.getElementById('apostar').disabled = false;
	document.getElementById('girarRuleta').disabled = false;
}

function mostrarJugadas(tipoApuesta, valorApuesta, nombreApuesta){
	var apuestaTexto = "<p>Apuesta seleccionada: " + tipoApuesta + "-" + nombreApuesta + "</p>";	
	document.getElementById('jugada').innerHTML = apuestaTexto;
	
	
	document.getElementById('apuestaTipo').value = tipoApuesta;
	document.getElementById('opcionNombre').value = nombreApuesta;
	validarApostar();
	mostrarColeccionApuestas();
	
}

function mostrarColeccionApuestas(){
	tipoApuesta = document.getElementById('apuestaTipo').value;
	nombreApuesta = document.getElementById('opcionNombre').value;	
	var apuestasColeccion = "";	
	for(var i = 0; i<apustasrealizadas.length; i++){
		if(apustasrealizadas[i].tipo == tipoApuesta && apustasrealizadas[i].jugada == nombreApuesta){
			apuestasColeccion += "<div class=\"jugadacollecion\"><p>" + tipoApuesta + "-" + nombreApuesta + " <img src=\"images/chip.png\"> " + apustasrealizadas[i].fichas + "</p></div>";			
		}				
	}	
	document.getElementById('apuestasColeccion').innerHTML = apuestasColeccion;
	
}

function submitEnterLogin(myfield,e){
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else if (e) keycode = e.which;
	else return true;
    if (keycode == 13)
	    {    	
		validarYEnviar();
	    //myfield.form.submit();
	    }
	}

function validarYEnviar(){
    
	var formulario = document.getElementById('form_log');
	var nombre = document.getElementById('nombreJugador');
	var dinero = document.getElementById('dineroJugador');
	var RegExNombre = /^[a-zA-Z]+$/;
	var RegExDinero = /^[0-9]*[1-9]+[0-9]*$/;
	if(nombre.value.match(RegExNombre)){
		if(dinero.value.match(RegExDinero)){
			formulario.submit();
		}
		else{
			alert('Dinero incorrecto');
			dinero.focus();			
		}
	}
	else{
		alert('Nombre incorrecto');
		nombre.focus();
	}
	
}

function ajaxFunction(){
  var xmlHttp;
  try{
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
    return xmlHttp;
    }
  catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
      return xmlHttp;
      }
    catch (e){
      try{
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      return xmlHttp;
      }
      catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
    }
  }
}

function fixRGB(aleatorio){
	  switch (aleatorio)
	    {
	    case 1:
	      return "a";
	      break;
	    case 2:
	      return "b";
	      break;
	    case 3:
	      return "c";
	      break;
	    case 4:
	      return "d";
	      break;
	    case 5:
	      return "e";
	      break;
	    case 6:
	      return "f";
	      break;
	    default:
	      return aleatorio;
	    }
}


function registrar(texto){
	var rgb = "#" + fixRGB(Math.floor(Math.random()*10)) + fixRGB(Math.floor(Math.random()*10)) + fixRGB(Math.floor(Math.random()*10));
	//alert(rgb);
	document.getElementById('registrar').innerHTML += "<p style=\"color:" + rgb +"\">" + texto + "</p>";
}

function girarRuleta(){
	if(!enviando){	
	  bloquearEnvios();
	  var ajax;
	  ajax = new ajaxFunction();
	  var catchError = setTimeout(function(){ajax.abort();mostrarError("Error en la conexion, intentelo nuevamente");desbloquearEnvios();}, 10000);
      ajax.onreadystatechange = function(){
	    if(ajax.readyState == 4){	
          if(ajax.status == 200){
            clearTimeout(catchError);
        	registrar(ajax.responseText);
        	var respuestaServer = eval(ajax.responseText);
        	if(respuestaServer[0] == 1){//hubo un error
        		mostrarError(respuestaServer[1]);
        	}
        	else if(respuestaServer[0] == 2){
        		loggear();
        	}else{
        		actualizarEstado(respuestaServer);
        		//alert()
        		document.getElementById('numeroGanadorVista').innerHTML ="Numero ganador: "+ respuestaServer[3];
        	}
            desbloquearEnvios();
          }
        }
	  }
      var envio = "getapuestas?girarruleta=true";
      //alert(envio);
	  ajax.open("GET", envio, true);
	  ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  ajax.send(null);
	}
}

function validarApostar(){
	//alert('validando');
	var disponibles = document.getElementById('fichasHidden').value;
	var quiereApostar = document.getElementById('apuestaFichas').value;
	var tipoApuesta = document.getElementById('apuestaTipo').value;
	
	if(quiereApostar == ""){
		document.getElementById('apostar').disabled = true;
		registrar('input vacio');
	}
	else if(parseInt(quiereApostar) > parseInt(disponibles)){
		document.getElementById('apostar').disabled = true;	
		registrar('Apuesta mayor a cantidad de fichas');
	}
	else if(!quiereApostar.match(/^[0-9]*[1-9]+[0-9]*$/)){
		document.getElementById('apostar').disabled = true;
		registrar('No es un numero mayor a 0');
	}
	else if(tipoApuesta == ""){
		document.getElementById('apostar').disabled = true;	
		registrar('No se ha seleccionado apuesta');	
	}
	else{
		document.getElementById('apostar').disabled = false;
		registrar('validado Ok');	
	}	
}

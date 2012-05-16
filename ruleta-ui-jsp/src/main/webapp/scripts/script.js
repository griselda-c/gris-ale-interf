var enviando = false;
var apustasrealizadas = new Array();
var apuestasServer;


function ApuestaWeb(tipoP, jugadaP, fichasP){
	  this.tipo = tipoP;
	  this.jugada = jugadaP;
	  this.fichas = fichasP;
	  this.procesada = false;
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
	  var jugada = document.getElementById('opcionValor').value;
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
          }
        }
	  }
	  ajax.open("GET","apostar?apuesta=" + tipo + "&jugada=" + jugada + "&fichasapostar=" + fichas, true);
	  ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  ajax.send(null);
	}
}


function loggear(){
	alert("debe iniciar session para poder apostar");
	header("location: index.jsp");
}

function actualizarEstado(arrayEstado){
	document.getElementById('fichasHidden').value = arrayEstado[1];
	document.getElementById('fichasVista').innerHTML = "Fichas disponibles: " + arrayEstado[1];	
		
	apuestasServer = new Array();;
	alert(apuestasServer.length);
	for(var i = 0; i<arrayEstado[2].length; i++){
		apuestasServer.push(new ApuestaWeb(arrayEstado[2][i][0], arrayEstado[2][i][1], arrayEstado[2][i][3]));
	}
	
	//"procesar" las que estan ya apostadas
	for(var i = 0; i<apustasrealizadas.length; i++){
		var contador = 0;
		var maximo = apuestasServer.length;
		var encontrado = false;
		
		while((contador<maximo) && (!encontrado)){
			if(apuestasServer[contador].equals(apustasrealizadas[i]) && !apuestasServer[contador].procesada){
				apuestasServer[contador].procesar();
				apustasrealizadas[i].desapostar;
				encontrado = true;
			}
		}
		
	}
	
	for(var i = 0; i<apuestasServer.length; i++){
		if(!apuestasServer[i].procesada){
			apuestasServer[i].apostar();
			apuestasServer[i].procesar();
		}
	}
	
	apustasrealizadas = apuestasServer;
	//alert(arrayEstado[2][i][1]);
	//alert(apuestasServer.length);
	}

function mostrarError(descripcionError){
	alert(descripcionError);
}

function bloquearEnvios(){
	enviando = true;
	document.getElementById('apostar').disabled = true;
}


function desbloquearEnvios(){
	enviando = false;
	document.getElementById('apostar').disabled = false;
}


function mostrarJugadas(tipoApuesta, valorApuesta, nombreApuesta){
	var tipoTexto = "<p>Apuesta seleccionada: " + tipoApuesta + "-" + nombreApuesta + "</p>";	
	document.getElementById('apuestaTipo').value = tipoApuesta;
	document.getElementById('opcionValor').value = nombreApuesta;	
	document.getElementById('jugada').innerHTML = tipoTexto;	
}


function submitEnterLogin(myfield,e){
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else if (e) keycode = e.which;
	else return true;

	if (keycode == 13)
	   {
	   myfield.form.submit();
	   }
	}



function init(){
	loadAndFormat();
}

function loadAndFormat(){
	
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
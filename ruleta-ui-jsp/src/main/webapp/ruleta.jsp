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


	<p align= center>Bienvenido:<%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>${sessionScope.jugador.nombre}<%
	}%></p>
	<br/><br/>
	
	<p align= center>Fichas:<%
	if (request.getSession().getAttribute("jugador") != null) {
	// abro%>${sessionScope.jugador.fichas}<%
	}%>"</p>
	<br/><br/>
	
	<p align= center>Realice sobre la mesa sus apuestas</p>
	

    <form  method="post" action="apostar" id="body">
    
	
	<table border="2" align= center>
    <tr>  <td colspan="3" align="center"> 
             <input type ="submit" id="pleno"value="0"></input>
               
           </td> 
    </tr>
    
    <tr>
       
        <td>1<input type ="checkbox" id="pleno"value="1"></input></td>
        <td><input type ="submit" id="pleno"value="2"></input></td>
        <td><input type ="submit" id="pleno"value="3"></input></td>
        
  
        
        
    </tr>
    
    <tr>
        
        <td><input type ="submit" id="pleno"value="4"></input></td>
        <td><input type ="submit" id="pleno"value="5"></input></td>
        <td><input type ="submit" id="pleno"value="6"></input></td>
         <td rowspan="3"><input type ="submit" id="par-impar"value="Impar"></input> </td>
        
  
        
        
    </tr>
    
     <tr>
        
        <td><input type ="submit" id="pleno"value="7"></input></td>
        <td><input type ="submit" id="pleno"value="8"></input></td>
        <td><input type ="submit" id="pleno"value="9"></input></td>
        
        
  
        
        
    </tr>
     <tr>
        
        <td><input type ="submit" id="pleno"value="10"></input></td>
        <td><input type ="submit" id="pleno"value="11"></input></td>
        <td><input type ="submit" id="pleno"value="12"></input></td>
        
  
        
        
    </tr>
    
     <tr>
        <td><input type ="submit" id="pleno"value="13"></input></td>
        <td><input type ="submit" id="pleno"value="14"></input></td>
        <td><input type ="submit" id="pleno"value="15"></input></td>
        
      </tr>
      
      <tr>
        <td><input type ="submit" id="pleno"value="16"></input></td>
        <td><input type ="submit" id="pleno"value="17"></input></td>
        <td><input type ="submit" id="pleno"value="18"></input></td>
      </tr>
     
     <tr>
        <td><input type ="submit" id="pleno"value="19"></input></td>
        <td><input type ="submit" id="pleno"value="20"></input></td>
        <td><input type ="submit" id="pleno"value="21"></input></td>
        <td rowspan="3"><input type ="submit" id="par-impar"value="Par"></input> </td>
        
      </tr> 
      
      <tr>
        <td><input type ="submit" id="pleno"value="22"></input></td>
        <td><input type ="submit" id="pleno"value="23"></input></td>
        <td><input type ="submit" id="pleno"value="24"></input></td>
      </tr>
      
      <tr>
        <td><input type ="submit" id="pleno"value="25"></input></td>
        <td><input type ="submit" id="pleno"value="26"></input></td>
        <td><input type ="submit" id="pleno"value="27"></input></td>
      </tr>
      
      <tr>
        <td><input type ="submit" id="pleno"value="28"></input></td>
        <td><input type ="submit" id="pleno"value="29"></input></td>
        <td><input type ="submit" id="pleno"value="30"></input></td>
      </tr>
      
      <tr>
        <td><input type ="submit" id="pleno"value="31"></input></td>
        <td><input type ="submit" id="pleno"value="32"></input></td>
        <td><input type ="submit" id="pleno"value="33"></input></td>
      </tr>
      <tr>
        <td><input type ="submit" id="pleno"value="34"></input></td>
        <td><input type ="submit" id="pleno"value="35"></input></td>
        <td><input type ="submit" id="pleno"value="36"></input></td>
      </tr>
      
     <tr> <th><input type ="submit" id="columna"value="Colum 1"></input></th>
     <th><input type ="submit" id="columna"value="Colum 2"></input></th>
     <th><input type ="submit" id="columna"value="Colum 3"></input></th></tr>
      
      
    </table>
	
     <input type="button" value="Retirarse" id="retirarse"/>
	
	<input type="button" value="Cambiar Fichas" id="ficha"/>
     
    </form>
	




</body>
</html>
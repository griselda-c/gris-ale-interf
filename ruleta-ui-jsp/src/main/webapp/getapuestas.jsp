<%@ page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
  if (request.getSession().getAttribute("model") != null) {	 
	
	  
	  
	%>[0, ${sessionScope.model.jugador.fichas}, [
	<c:forEach var="apuestaG" items="${sessionScope.model.jugador.apuestas}">
	["<c:out value="${apuestaG.tipoApuesta}"/>", "<c:out value="${apuestaG.jugadaSeleccionada.nombre}"/>", <c:out value="${apuestaG.jugadaSeleccionada.valor}"/>, <c:out value="${apuestaG.fichas}"/>],
	</c:forEach>],${sessionScope.model.mesa.numeroGanador}]
	<%
  }
  else{
	%> [2, "Debe iniciar sesion para poder apostar"] <%
  }%>
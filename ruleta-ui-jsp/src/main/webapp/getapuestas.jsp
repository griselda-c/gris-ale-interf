<%@ page isELIgnored ="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%
  if (request.getSession().getAttribute("model") != null) {
	%>[0, ${sessionScope.model.jugador.fichas}, [
	<c:forEach var="apuesta" items="${sessionScope.model.jugador.apuestas}">
	["<c:out value="${apuesta.tipoApuesta}"/>", "<c:out value="${apuesta.jugadaSeleccionada.nombre}"/>", <c:out value="${apuesta.jugadaSeleccionada.valor}"/>, <c:out value="${apuesta.fichas}"/>],
	</c:forEach>]]
	<%
  }
  else{
	%> [2, "Debe iniciar sesion para poder apostar"] <%
  }%>
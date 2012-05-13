<%@ page isELIgnored ="false" %>

<% if (request.getSession().getAttribute("jugador") != null) {
	// abro%> ${sessionScope.apuestas} <%
	}
	else{
	// abro%> nada aun <%
	}%>
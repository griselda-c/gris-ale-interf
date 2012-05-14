<%@ page isELIgnored ="false" %>

<% if (request.getSession().getAttribute("errorApuesta") != null) {
	// abro%><br/> error <br/> ${sessionScope.errorApuesta} <%
	}
	else{
	// abro%> nada aun <%
	}%>
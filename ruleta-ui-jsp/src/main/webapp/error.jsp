<%@ page isELIgnored ="false" %>
<% if (request.getSession().getAttribute("errorApuesta") != null) {
	%>[1, "${sessionScope.errorApuesta}"]<%}
	else{%>[1, "el error es mas grave de lo que se esperaba: no hay error"]<%}%>